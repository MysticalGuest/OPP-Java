package com.arrayList.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 对比ArrayList随机访问和顺序访问效率
public class TimeComparison1 {
	public static void main(String[] args) {
		//创建ArrayList集合
		List<String> list = new ArrayList<>();
		//添加10W条数据
		for (int i = 0; i < 100000; i++) {
			list.add(i+"a");
		}
		System.out.println("----通过索引(随机访问:)----");
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < list.size(); i++) {
			//仅仅为了演示取出数据的时间,因此不对取出的数据进行打印
			list.get(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("随机访问: "+(endTime-startTime));
		
		System.out.println("----通过迭代器(顺序访问:)----");
		
		startTime = System.currentTimeMillis();
		Iterator<String> it = list.iterator();
		while (it.hasNext()){
			//仅仅为了演示取出数据的时间,因此不对取出的数据进行打印
			it.next();
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("顺序访问: "+(endTime-startTime));
	}

}
