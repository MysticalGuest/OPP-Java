 package com.copy;

 /**
 * @author MysteryGuest
 * @date 2021/04/20
 * 深拷贝：
 *   这是拷贝了对象的所有值而不是地址，所以即使源对象的值发生任何变化时，拷贝对象的值也不会改变
 */
public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        TeacherDeepClone teacher = new TeacherDeepClone();
        teacher.setName("Gin");
        teacher.setAge(25);
        
        StudentDeepCopy s1 = new StudentDeepCopy();
        s1.setName("Tom");
        s1.setAge(18);
        s1.setTeacher(teacher);
        
        StudentDeepCopy s2 = (StudentDeepCopy)s1.clone();
        
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
         * 两个引用student1和student2指向不同的两个对象，两个引用student1和student2中的两个teacher引用指向的是两个对象，
         * 但对teacher对象的修改只能影响student1对象,所以说是深拷贝。
         * */
    }
}

class TeacherDeepClone implements Cloneable {
    private String name;
    private int age;

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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class StudentDeepCopy implements Cloneable {
    private String name;
    private int age;
    private TeacherDeepClone teacher;

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

    public TeacherDeepClone getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDeepClone teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 浅复制时：
        // Object object = super.clone();
        // return object;

        // 改为深复制：深拷贝的实现
        StudentDeepCopy student = (StudentDeepCopy) super.clone();
        // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
        student.setTeacher((TeacherDeepClone) student.getTeacher().clone());
        return student;

    }
}