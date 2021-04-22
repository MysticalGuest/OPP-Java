package com.copy;

/**
* @author MysteryGuest
* @date 2021/04/20
* 引用拷贝
*/
public class QuoteCopy {

	public static void main(String[] args) {
		Teacher mrWang = new Teacher("WangWu", 28);
		
		// 创建一个指向对象的引用变量的拷贝
		Teacher misWang = mrWang;
		
		System.out.println(mrWang);
		System.out.println(misWang);
		/*
		 * 结果分析：由输出结果可以看出，它们的地址值是相同的，那么它们肯定是同一个对象。
		 * 栈区存放的MrWang和MisWang的只是引用而已，他们都指向了一个相同的堆区对象Teacher("WangWu", 28)。 
		 * 这就叫做引用拷贝。
		 * */

	}

}

class Teacher {

	private String name;
    private int age;

    public Teacher(String name, int age) {
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
}