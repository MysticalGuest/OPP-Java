package com.arrays;


/**
 * @since JDK 1.8
 * 案例: 
 * 已知A对象的姓名为Tom，年龄30 。由于项目特殊要求需要将该对象的数据
 * 复制另外一个对象B中，并且此后A和B两个对象的数据不会相互影响
 *
 *	浅拷贝的局限性
 */
public class TestClone {
	
	public static void main(String[] args) throws CloneNotSupportedException {
        // 创建学生对象
        StudentCloneable stu1 = new StudentCloneable("Tom", 30);
        // 调用clone的方法进行数据的拷贝
        Object stu2 = stu1.clone();
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1 == stu2);
        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println("----此时不管修改哪个对象的内容,stu1和stu2都不会受到影响----");
        // 更改stu1对象的内容, 深拷贝？
        stu1.setAge(33);
        System.out.println(stu1);
        System.out.println(stu2);
    }

}

class StudentCloneable implements Cloneable{
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
    
    /* 注意:
     * 首先方法的权限修饰符需要更改为public
     * 方法的返回值可以更改为当前类的类名
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
