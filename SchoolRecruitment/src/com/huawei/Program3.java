package com.huawei;

import java.util.Scanner;

public class Program3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String in[] = S.split(",");
		int num = Integer.parseInt(in[1]);
		int left=0, mid=num-2, right=0;
		String rectangle[][] = new String[num*2][num];
		int k=0;
		for(int i=0; i < num*2; i++) {
			for(int j=0; j<num ;j++) {
				j+=left;
				if(j>num-1)
					break;
				System.out.println(i+"    "+j);
				rectangle[i][j]=in[0].charAt(k)+"";
				j+=mid;
				if(j>num-1)
					break;
				rectangle[i][j]=in[0].charAt(k++)+"";
				j+=right;
			}
			if(num<(i%4+1)*2) {
				left--;
				mid+=2;
				right--;
			} else {
				left++;
				mid-=2;
				right++;
			}
		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num*2; j++) {
				if(rectangle[j][i]!=null)
					System.out.print(rectangle[j][i]);
			}
		}
	}

}
