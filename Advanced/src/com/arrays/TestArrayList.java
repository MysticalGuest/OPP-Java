package com.arrays;

import java.util.ArrayList;

/**
 *
 * ArrayList有参构造源码分析
 */
public class TestArrayList {
	public static void main(String[] args) {
        // ArrayList(Collection <? extends E> c) 构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的顺序。
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.size());

        // 这行代码做了什么?
        ArrayList<String> new_list = new ArrayList<>(list);
        System.out.println(new_list);

        /*
         * 克隆的基本使用:
         * 将ArrayList集合的数据clone到另外一个集合
         * */
        System.err.println("Test public Object clone(): ");
        // 调用方法进行克隆
        Object o = list.clone();
        
        System.out.println("Test public boolean equals(Object obj): ");
        // equals()方法比较的是两个对象的实际内容
        System.out.print(o.equals(list));
        System.out.println(list.equals(new_list));
        
        System.out.println("Test \"==\" : ");
        // false, 指向不同对象, “==”比较的是两个引用的对象是否相等
        System.out.print(o == list);
        System.out.println(list == new_list);
        System.out.println(o);
        System.out.println(list);
    }
}

/*
 * 源码：
public class ArrayList<E> {
    // 长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    // 集合存元素的数组
    Object[] elementData;

    // 集合的长度
    private int size;

    public ArrayList(Collection<? extends E> c) {
        // 将构造方法中的参数转成数组
        elementData = c.toArray();

        if ((size = elementData.length) != 0) {
            // 再次进行判断
            if (elementData.getClass() != Object[].class)
                // 数组的创建和拷贝
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // 就把空数组的地址赋值给集合存元素的数组
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    //将集合转数组的方法
    public Object[] toArray() {
        //调用数组工具类的方法
        return Arrays.copyOf(elementData, size);
    }
}

class Arrays {
    public static <T> T[] copyOf(T[] original, int newLength) {
        //再次调用方法得到一个数组
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        //不管三元运算符的结果如何,都会创建一个新的数组
        //新数组的长度一定是和集合的size一样
        T[] copy = ((Object)newType == (Object)Object[].class)
            ? (T[]) new Object[newLength]
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        //数组的拷贝
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        //返回新数组
        return copy;
    }
}
 */
