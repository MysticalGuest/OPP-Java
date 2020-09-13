package com.the360safe;

import java.util.Scanner;

// 测试密码复杂度
public class Program2 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String password;

		boolean isfit;
		
		while (input.hasNext()) {
			// 下标0表示数字，1表示小写字母，2表示大写字母，3表示其他
			int flag[] = {0, 0, 0, 0};
			isfit = true;
			password = input.next();
			char[] array = password.toCharArray();
			for (int i = 0; i < array.length; i++) {
				if(array[i]>='1'&&array[i]<='9') {
					flag[0]++;
				} else if (array[i]>='a'&&array[i]<='z') {
					flag[1]++;
				} else if (array[i]>='A'&&array[i]<='Z') {
					flag[2]++;
				} else {
					flag[3]++;
				}
			}
			
			for (int i = 0; i < flag.length; i++) {
				if(flag[i]==0) {
					isfit=false;
				}
			}
			
			if(isfit) {
				System.out.println("OK");
			} else {
				System.out.println("Illegal Password");
			}
		}
		
		input.close();
	}

}
