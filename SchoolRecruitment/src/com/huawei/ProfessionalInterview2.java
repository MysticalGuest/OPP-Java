package com.huawei;

import java.util.ArrayList;

public class ProfessionalInterview2 {


}

class MyCollection{
	
	private ArrayList<Integer> arrayList;
	
	public MyCollection() {
	}
	
	public void put(int elem) {
		this.arrayList.add(elem);
	}
	
	public void delete(int elem) {
		if (arrayList.indexOf(elem)!=-1) {
			this.arrayList.remove(elem);
		}
	}
	
	// 如果arrayList为空，那么size就是0，除法就崩溃了，所以要判断是否为空，面试的时候就没考虑到
	public double getAverage() {
		if (arrayList.size()==0) {
			return 0;
		}
		int sum=0;
		for (Integer integer : arrayList) {
			sum+=integer;
		}
		return sum/arrayList.size();
	}
}