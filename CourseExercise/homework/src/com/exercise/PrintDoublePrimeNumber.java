package com.exercise;

// exercise p203_6_23
public class PrintDoublePrimeNumber {
	public static void main(String[] args) {
		int [] temp ={0,0};
		int k=0,j;
		for( int i=2 ; i<=1000 ; i++ ){
			for(  j=2 ; j<=Math.sqrt(i) ; j++ )
				if(i%j==0){
					j=2;
					break;
					}
			if(k<2&&j>Math.sqrt(i)){
				temp[k]=i;
				k++;
			}
			
			if(k==2){
				if(temp[1]-temp[0]==2)
					System.out.println("(" + temp[0] + ", " + temp[1] + ")");
				temp[0]=temp[1];
				k=1;
			}
		}
	}

}

