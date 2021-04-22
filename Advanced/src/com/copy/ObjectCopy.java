package com.copy;

/**
* @author MysteryGuest
* @date 2021/04/20
* 对象拷贝
*/
public class ObjectCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
    	TeacherWithClone mrWang = new TeacherWithClone("WangWu", 28);
		
		// 创建对象本身的一个副本
    	TeacherWithClone misWang = (TeacherWithClone) mrWang.clone();
		System.out.println(mrWang);
		System.out.println(misWang);
		
		/*
		 * 结果分析：由输出结果可以看出，它们的地址是不同的，也就是说创建了新的对象，
		 * 而不是把原对象的地址赋给了一个新的引用变量，这就叫做对象拷贝。
		 * 
		 * 注：深拷贝和浅拷贝都是对象拷贝！！！！！
		 * */
    }
}

class TeacherWithClone implements Cloneable {
    private String name;
    private int age;
    
    public TeacherWithClone() {
    }

    public TeacherWithClone(String name, int age) {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
