package com.arrayList.entity;

public class StudentCloneable implements Cloneable{
    //姓名
    private String name;
    //年龄
    private int age;

    public StudentCloneable() {
    }

    public StudentCloneable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    /*	注意:
     *		首先方法的权限修饰符需要更改为public
     *		方法的返回值可以更改为当前类的类名
    */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}