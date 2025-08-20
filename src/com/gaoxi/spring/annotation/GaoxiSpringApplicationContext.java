package com.gaoxi.spring.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

//本类的作用类似Spring原生ioc容器ApplicationContext
public class GaoxiSpringApplicationContext {
    private Class configClass;
    //ioc中存放的就是通过反射创建的对象(基于注解的方式)
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    //构造器
    public GaoxiSpringApplicationContext(Class configClass) {
        this.configClass = configClass;
        //System.out.println("this.configClass=" + this.configClass);
        //获取要扫描的包
        //1.先得到GaoxiSpringConfig配置的注解@ComponentScan(value="com.gaoxi.spring.component")
        ComponentScan componentScan = (ComponentScan)this.configClass.getDeclaredAnnotation(ComponentScan.class);
        //2.通过ComponentScan的value->即要扫描的包
        String path = componentScan.value();
        //System.out.println("要扫描的包=" + path);
        //得到要扫描的包(out目录)下的所有资源(类.class)
        //1.先得到类的加载器
        ClassLoader classLoader = GaoxiSpringApplicationContext.class.getClassLoader();
        //2.通过类的加载器获取到要扫描的包的资源url:
        //  file:/Users/firespite/IdeaProjects/spring/out/production/spring/com/gaoxi/spring/component
        //URL resource = classLoader.getResource("com/gaoxi/spring/component");
        path = path.replace(".", "/");//把路径中的.替换成/
        URL resource = classLoader.getResource(path);
        //System.out.println(resource);
        //3.将要加载的资源(.class)路径下的文件进行遍历->IO
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //System.out.println("===========");
                //System.out.println(f.getAbsoluteFile());
                String fileAbsolutePath = f.getAbsolutePath();
                //这里我们只处理.class文件
                if (fileAbsolutePath.endsWith(".class")) {
                    //1.先获取到类名
                    String className = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf("/") + 1, fileAbsolutePath.lastIndexOf(".class"));
                    //System.out.println(className);
                    //2.获取类的全类名(带路径)
                    path = path.replace("/", ".");//com/gaoxi/spring/component -> com.gaoxi.spring.component
                    String classFullName = path + "." + className;
                    //3.判断该类是否要反射注入到容器中，就看该类是不是有注解@Component @Service @Repository @Controller
                    try {
                        //两种方式都可以反射加载一个类的class对象，区别是下面的方式会调用该类的静态方法，上面的方式就不会
                        Class<?> aClass = classLoader.loadClass(classFullName);
                        //Class clazz = Class.forName(classFullName);
                        //4.isAnnotationPresent判断该类是否有Comonent注解
                        if (aClass.isAnnotationPresent(Component.class) ||
                            aClass.isAnnotationPresent(Controller.class) ||
                            aClass.isAnnotationPresent(Service.class) ||
                            aClass.isAnnotationPresent(Repository.class)) {
                            //这时就可以反射对象，并放入容器，此时用forName
                            Class<?> clazz = Class.forName(classFullName);
                            Object instance = clazz.newInstance();
                            //将实例放入容器
                            //ioc.put("类名(首字母小写)", 对象);
                            //ioc.put(this.lowerCaseFirstLetter(className), instance);
                            ioc.put(StringUtils.uncapitalize(className), instance);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    //编写方法，返回容器对象
    public Object getBean(String name) {
        return ioc.get(name);
    }

    //编写方法，将类名的首字母改成小写
    public String lowerCaseFirstLetter(String className) {
        return className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
    }
}
