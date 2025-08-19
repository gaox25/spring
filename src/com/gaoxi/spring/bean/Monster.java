package com.gaoxi.spring.bean;
//JavaBean/Entity
public class Monster {
    private Integer monsterId;
    private String name;
    private String skill;

    //无参构造器一定要写，Spring反射创建对象时，需要使用
    public Monster() {
    }

    public Monster(Integer monsterId, String name, String skill) {
        System.out.println("全参构造器被调用了");
        this.monsterId = monsterId;
        this.name = name;
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
