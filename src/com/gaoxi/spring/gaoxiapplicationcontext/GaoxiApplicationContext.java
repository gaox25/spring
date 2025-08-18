package com.gaoxi.spring.gaoxiapplicationcontext;

import com.gaoxi.spring.bean.Monster;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
 1.这个程序用于实现Spring的一个简单容器机制
 2.后面还会详细的实现
 3.这里实现如何将beans.xml文件进行解析并生成对应的对象，放入容器中
 4.提供一个方法 getBean(id)，返回对应的对象
 5.这里就是一个开胃小点心，理解Spring容器的机制
 */
@SuppressWarnings({"all"})
public class GaoxiApplicationContext {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    //构造器
    //接收一个容器的配置文件，比如beans.xml，该文件默认在src下
    public GaoxiApplicationContext(String iocBeanXmlFile) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1.得到类加载路径
        String path = this.getClass().getResource("/").getPath();
        //2.创建Saxreader
        SAXReader saxReader = new SAXReader();
        //3.得到Document对象
        Document document = saxReader.read(new File(path + iocBeanXmlFile));
        //4.得到rootDocument(根元素)
        Element rootElement = document.getRootElement();
        //5.得到第一个bean monster01
        Element bean = (Element) rootElement.elements("bean").get(0);
        //6.获取到第一个bean monster01的相关属性
        String id = bean.attributeValue("id");
        String classFullPath = bean.attributeValue("class");
        System.out.println("id = " + id);
        System.out.println("classFullPath = " + classFullPath);
        List<Element> property = bean.elements("property");
        //遍历->简化直接获取
        Integer monsterId = Integer.parseInt(property.get(0).attributeValue("value"));
        String name = property.get(1).attributeValue("value");
        String skill = property.get(2).attributeValue("value");
        //System.out.println( masterId + " " + name + " " + skill);
        //7.使用反射创建对象
        Class<?> aClass = Class.forName(classFullPath);
        Monster o = (Monster) aClass.newInstance();
        //给o对象赋值
        //使用反射来赋值
        /*
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.invoke();
        }
         */
        //简化赋值，实际上Spring底层不会通过set方法set数据，这里是为了先理解顺序
        o.setMonsterId(monsterId);
        o.setName(name);
        o.setSkill(skill);
        //8.将创建好的对象放入到singletonObjects
        singletonObjects.put(id, o);
    }
    public Object getBean(String id) {
        return singletonObjects.get(id);
    }
}
