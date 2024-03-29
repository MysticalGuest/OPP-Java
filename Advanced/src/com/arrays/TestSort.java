package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 在算法练习时，接触到Arrays包的sort方法；
 * 这里来学学它的使用方法和底层原理
 * 
 * 不论是Collections.sort方法或者是Arrays.sort方法，底层实现都是TimSort实现的，这是jdk1.7新增的，以前是归并排序。
 * TimSort算法就是找到已经排好序数据的子序列，然后对剩余部分排序，然后合并起来
 * */
public class TestSort {
	
	//通过id排序
	public static class SortById implements Comparator<Senior>{
	    @Override
	    public int compare(Senior o1, Senior o2) {
	        return o1.id - o2.id;
	    }
	}

	//通过age排序
	public static class SortByAge implements Comparator<Senior>{
	    @Override
	    public int compare(Senior o1, Senior o2) {
	        return o1.age - o2.age;
	    }
	}
	
	public static void main(String[] args) {
		/*一、基本数据类型*/
		// 数字类型:从小到大排序(浮点类型与整形同理)
		int[] a = {1, 3, 4, 67, 78, 9, 90, 6, 3, 2};
        Arrays.sort(a); // 对数组进行排序
        System.out.println(Arrays.toString(a)); // 遍历并输出整个数组
        
        // 字符串类型
        String[] strArray1 = new String[]{"Zs","ZA", "aa", "Az","D","w","A","z", "a"};
        // 大写在小写前,从A~Z依次往下排,若第一位相同则比较第二位,规则相同,若第三位也相同,依次往下比较.
        Arrays.sort(strArray1);
        System.out.println(Arrays.toString(strArray1));
        
        // 忽略大小写
        String[] strArray2 = new String[]{"hello","Hello", "Hello kity", "hello kity","D","w","A","z","a"};
        Arrays.sort(strArray2 ,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArray2));
        
        // 对象数组
        Senior s1 = new Senior(11110, 13);
        Senior s2 = new Senior(11112, 12);
        
        Senior[] ss = {s1, s2};
        Arrays.sort(ss, new SortById()); // 按Id排序
        for (Senior s : ss) {
            System.out.print(s+" ");
        }
        
        System.out.println();
        Arrays.sort(ss, new SortByAge()); // 按年龄排序
        for (Senior s : ss) {
            System.out.print(s+" ");
        }
        
        // 2022年1月27日，排序数组
        int[][] intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        /**
         * 根据指定的比较器引发的顺序对指定的对象数组进行排序
         * public static <T> void sort(T[] a, Comparator<? super T> c)
         * Comparator<T>是一个函数式接口，接口无法直接创建对象，但是sort方法需要一个Comparator对象作为参数；
         * 就是需要创建Comparator接口的实现类来创建对象，才可以传入sort方法。
         * 如果这个接口Comparator的实现类需要重复使用，则将该实现类定义成一个独立类；
         * 如果这个类只需一次性使用，则可定义成**匿名内部类**。
         * @FunctionalInterface
         * public interface Comparator<T>
         * 
         * */ 
        Arrays.sort(intervals, new Comparator<int[]>() {
            // 通过数组中第一个数比较排序
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0]-intervals2[0];
            }
        });
        // 匿名内部类等价于
        class myComparator implements Comparator<int[]>{
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0]-intervals2[0];
            }
        };
        Arrays.sort(intervals, new myComparator());
        System.out.println("\nintervals排序后：");
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(intervals[i][j]+"   ");
            }
            System.out.println();
        }
        
	}
	
	/*
	 * 为什么sort()都可以排序呢?而且时间和空间复杂度都还比较优良,有没有人想过sort()里面是怎么实现的呢?
	 * 
	 * 其实sort()是根据需要排序的数组的长度进行区分的:
	 * 当你的数组长度是小于60的,它会直接进行一个插入排序;
	 * 当长度大于60时,有可能会merge排序或者是quick排序,merge和quick会将整个数组进行划分,进行递归,
	 * 一旦划分的子数组长度小于60时,将不再递归划分,直接进行插入排序.为什么会这么排序呢?
	 * 
	 * 原因是,在数据量小的时候.插入排序的常数代价非常低,虽然时间复杂度是O(n^2),但是常数项比较低.
	 * 此时此刻,在数据量比较小的时候,优势就展现出来了.
	 * 那么问题又来而来,当数据量比较大需要进行划分的时候,什么时候用merge,什么时候用quick呢?
	 * 这就要取决数组的类型了,当是基本数据类型的时候,会用quick,当是对象类型的时候会用merge.
	 * 因为当是基本数据类型的时候不需要考虑稳定性的因素,但是对象类型就要考虑了,
	 * 因为对象不止用来排序的这一个属性,可能已经在其他属性已经排好序了,在此番排序之后还需要保证数组的稳定性
	 * */

}

/*
 * 对象怎么进行排序呢?这时候就需要我们自己制定排序规则了(比如说,给student对象排序,是将学号id进行排序),
 * 但是如果是每个不同的类型的对象,我们都需要去分析数据,自己手动敲规则的话,过于麻烦.
 * 所以我们用到Comparable或者Comparator接口
 * */
class Senior  {
    int id;
    int age;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
    
    public Senior(int id, int age){
        this.id = id;
        this.age = age;
    }
    
}
