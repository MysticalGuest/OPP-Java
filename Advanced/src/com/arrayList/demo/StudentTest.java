package com.arrayList.demo;

import java.io.*;
import java.util.ArrayList;

/**
 * @since JDK 1.8
 *
 *	需求:
 *		已知4个学生对象,要求将4个学生对象序列化到当前模块根路径下的stu.txt中
 *		序列化成功后,请通过反序列化将文件中的数据读取出来,且打印到控制台
 *
 *	分析:
 *		创建ArrayList集合
 *		将要序列化的学生对象添加到集合
 *		序列化一次集合即可
 *		反序列化一次集合
 *		遍历集合
 */
public class StudentTest {
    public static void main(String[] args) throws Exception {
    	String path = "src/com/arrayList/demo/";
    	
        Student s1 = new Student("Tom", 51);
        Student s2 = new Student("Jack", 26);
        Student s3 = new Student("Lisa", 32);
        Student s4 = new Student("Tara", 27);
        // 创建ArrayList集合
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        // 创建对象操作流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"stu.txt"));
        //将集合写入到文件
        oos.writeObject(list);
        //关闭流
        oos.close();

        //反序列化
        //创建对象操作流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"stu.txt"));
        //读数据
        ArrayList<Student> list1 = (ArrayList<Student>) ois.readObject();
//        Object list1 = ois.readObject();
        //遍历集合
        for (Student student : list1) {
            System.out.println(student);
        }
    }
}

class Student implements Serializable{
    /**
     * The serializable class Student does not declare a static final serialVersionUID field of type long
     */
    private static final long serialVersionUID = 8727101498001680842L;
    //姓名
    private String name;
    //年龄
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
     *  分析:
     *      创建StringBuilder对象
     *      先追加一个当前类的类名,以及大括号、成员变量的名字以及='
     *      再追加成员变量对应的值
     *      再追加', 成员变量的名字以及=
     *      最后再次追加成员变量的名字 和 大括号
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{name='");
        sb.append(this.name);
        sb.append("', age=");
        sb.append(this.age);
        sb.append("}");
        return sb.toString();
    }
}
