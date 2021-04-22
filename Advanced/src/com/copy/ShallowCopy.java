 package com.copy;

 /**
 * @author MysteryGuest
 * @date 2021/04/20
 * 浅拷贝：
 *   只是拷贝了源对象的地址，所以源对象的任何值发生改变时，拷贝对象的值也会随之而发生变化
 */
public class ShallowCopy {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TeacherWithClone teacher = new TeacherWithClone();
        teacher.setName("WangWu");
        teacher.setAge(28);

        Student s1 = new Student();
        s1.setName("Tom");
        s1.setAge(18);
        s1.setTeacher(teacher);

        Student s2 = null;
        try {
            s2 = (Student) s1.clone();
        } catch (CloneNotSupportedException e) {
             e.printStackTrace();
        }
        
        System.out.println("-------------拷贝前-------------");
        System.out.println("s1: "+s1.getName()+" "+s1.getAge()+" "+s2.getTeacher().getName()+" "+s2.getTeacher().getAge());

        
        System.out.println("-------------拷贝后-------------");
        System.out.println("s2: "+s2.getName()+" "+s2.getAge()+" "+s2.getTeacher().getName()+" "+s2.getTeacher().getAge());

        System.out.println("--------修改老师的信息后---------");
        teacher.setName("jack");
        System.out.println("s1的teacher为： " + s1.getTeacher().getName());
        System.out.println("s2的teacher为： " + s2.getTeacher().getName());
        
        /*
         * 结果分析： 
         * 两个引用student1和student2指向不同的两个对象，
         * 但是两个引用student1和student2中的两个teacher引用指向的是**同一个对象**(比较与深拷贝的区别)，
         * 所以说明是浅拷贝。
         * */

    }

}

class Student implements Cloneable {
    private String name;
    private int age;
    private TeacherWithClone teacher;

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

    public TeacherWithClone getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherWithClone teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}