package com.the360safe;

import java.util.ArrayList;
import java.util.Scanner;

// 小A上班打卡问题
public class Program1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Record record;
		int numOfWorker;
		int numOfRecord;
		
		int id;//工号
		int flag;//是否上班

		
		while (input.hasNext()) {
			ArrayList<Record> arrayList = new ArrayList<>();
			numOfWorker = input.nextInt();
			numOfRecord = input.nextInt();
			
			for (int i = 0; i < numOfRecord; i++) {
				id = input.nextInt();
				flag = input.nextInt();
				record = new Record(id, flag);
				arrayList.add(record);
			}
			
			for (int i = 0; i < numOfRecord; i++) {
				if (arrayList.get(i).flag==1) {
					arrayList.add(new Record(arrayList.get(i).id, 0));
				} else {
					arrayList.add(0, new Record(arrayList.get(i).id, 1));
				}
			}
			

			if (arrayList.size()==2) {
				for (int i = 0; i < numOfWorker; i++) {
					System.out.print(i+1+" ");
				}
			} else {
				boolean b = true;
				for (int i = 0; i < numOfWorker; i++) {
//					for (int j = 0; j < numOfWorker; j++) {
//						if (arrayList.get(j).id==i+1) {
//							b=false;
//							break;
//						}
//					}
					if (b) {
						System.out.print(i+1+" ");
					}
				}
			}
		}
	}

}

class Record {
	int id;
	int flag;
	
	public Record(int id, int flag) {
		this.flag=flag;
		this.id=id;
	}
}
