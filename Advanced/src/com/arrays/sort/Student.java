package com.arrays.sort;


/*
 * 对象怎么进行排序呢?这时候就需要我们自己制定排序规则了(比如说,给student对象排序,是将学号id进行排序),
 * 但是如果是每个不同的类型的对象,我们都需要去分析数据,自己手动敲规则的话,过于麻烦.
 * 所以我们用到Comparable或者Comparator接口
 * */
public class Student  {
    int id;
    int age;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
    
    public Student(int id, int age){
        this.id = id;
        this.age = age;
    }
    
}
