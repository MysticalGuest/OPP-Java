package com.main;

public class CaptureCommunicationMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board=0,turn,Door,Day=0,SumDay=0;
		int [] person = new int[50];
		for(int sampling=0;sampling<10;sampling++){
			for(int i=0;i<50;i++)
				person[i]=0;
		    for(turn=0;turn<50;Day++) {
			    Door = (int)(Math.random()*50);
			    if(board==0&&Door==0){
			    	board=1;
			    	turn++;
			    	}
			    if(person[Door]==0&&board==1){
			    	person[Door]=1;
			    	board=0;
			    	}
			}
		System.out.printf("老爷爷要知道所有人是否都健在可能需要%d天。\n",Day);
		SumDay =SumDay + Day;
		board=0;
		Day=0;
		}
		System.out.printf("采样10次的平均值为%d\n",SumDay/10);
		

	}

}

