package com;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		System.out.print("日本人的人数是：");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		System.out.print("初始密码是：");
		int key = input.nextInt();
		int [] a = new int[number];
		int [] b = new int[number];
		int [] c = new int[number];
		int k,l=0,e;
		for(int i=0;i<number;i++)
			a[i]=1+(int)(Math.random()*number);
		for(int i=0;i<number;i++)
			b[i]=a[i];
		for(int i=0;i<number;i++){
			for(int j=0;j<number-i;j++){
				if(key>number-i)
					key=key+i-number;
				if((j+1)==key){
					l=a[j];
					k=key;
					e=number-key-i;
					for(int m=0;m<j;m++) {
						c[e]=a[m];
					    e++;
				}
					for(int n=0;n<number-key-i;n++)
						c[n]=a[k++];
					}
				if((j+1)==key)
					break;
				}
			for(int p=0;p<number-key;p++)
				a[p]=c[p];
			key=l;
	}
		for(int q=0;q<number;q++)
			if(a[0]==b[q])
				{
				System.out.println("游戏结束！");
				System.out.println("要去采摘的日本人的编号是："+q);
				break;}
		input.close();
		}
	}

