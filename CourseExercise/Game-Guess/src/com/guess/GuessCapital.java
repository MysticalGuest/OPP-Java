package com.guess;
import java.util.Scanner;

public class GuessCapital {

	public static void main(String[] args) {
		String [][] capital={
				{"Beijing","Beijing"},
				{"Hebei","shijiazhuang"},
				{"Tianjin","Tianjin"},
				{"Liaoning","Shenyang"},
				{"Shandong","Jinan"},
				{"Henan","Zhengzhou"},
				{"Jilin","Changchun"},
				{"Heilongjiang","Haerbin"},
				{"Neimenggu","Huhehaote"},
				{"Xinjiang","Wulumuqi"},
				{"Xizhang","Lasha"},
				{"Qinhai","Xining"},
				{"Gansu","Lanzhou"},
				{"Ningxia","Yinchuan"},
				{"Shanxi","Xian"},
				{"Shanxi","Taiyuan"},
				{"Jiangsu","Nanjing"},
				{"Anhui","Hefei"},
				{"Hubei","Wuhan"},
				{"Chongqing","Chongqing"},
				{"Sichuan","Chengdu"},
				{"Yunnan","Kunming"},
				{"Guizhou","Guiyang"},
				{"Hunan","Changsha"},
				{"Guangxi","Nanning"},
				{"Jiangxi","Nanchang"},
				{"Zhejiang","Hangzhou"},
				{"Shanghai","Shanghai"},
				{"Fujian","Fuzhou"},
				{"Guangdong","Guangzhou"},
				{"Taiwan","Taibei"},
				{"Xianggang","Xianggang"},
				{"Aomen","Aomen"},
				{"Hainan","Haikou"},
		};
		int score = 0,count = 0;
		int [] repe = new int[5];
		for(int turn=0;turn<5;turn++){
			int num = (int)(Math.random()*34);
			for(int i=0;i<turn;i++)
				if(num==repe[i]){
				    num = (int)(Math.random()*34);
				    i=0;
				}
			Scanner input = new Scanner(System.in);
			System.out.print("What is the capital of " + capital[num][0] + "?");
			String yourcapital = input.next();
			if(yourcapital.compareTo(capital[num][1])==0){
				score += 20;
				count++;
				System.out.println("Your answer is correct");
			}
			else
				System.out.println("The correct answer should be " + capital[num][1]);
			repe[turn]=num;
			/*
			 * Scanner（system.in）在Scanner中接受的是键盘 输入，当调用close（）方法时
			 * Scanner的关闭会导致System.in的关闭，System.in是标准输入（键盘输入），只能关一次，关闭后不能再打开
			*/
//			input.close();
		}
		System.out.println("Your correct count is " + count);
		System.out.println("Your final score is " + score);
		
	
	}

}
