package com.main;

import java.util.*;

public class nowcoder {

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//        int array[] = new int[100];
//        int sum=0;
//        while(num!=0){
//            if(num<1||num>100)
//                continue;
//            for(int i=0;i<num;i++){
//                array[i]=input.nextInt();
//                sum+=array[i];
//            }
//            System.out.println(sum);
//            sum=0;
//            num = input.nextInt();
//        }
//		Scanner input = new Scanner(System.in);
//        int N = input.nextInt();
//        int M = input.nextInt();
//        int score[] = new int[N];
//        for(int i=0; i<N; i++){
//            score[i]=input.nextInt();
//        }
//        for(int i=0; i<M; i++){
//        	String op = input.next();
//            if(op.equals("Q")) {
//                System.out.println(getMax(score, input.nextInt(), input.nextInt()));
//            }
//            else if(op.equals("U")) {
//                score[input.nextInt()-1]=input.nextInt();
//            }
//        }
		Scanner input = new Scanner(System.in);
        String s = input.nextLine();
//        String sa = "";
//	    for(int i=0; i<s.length(); i++) {
//	    	if(!sa.contains(s.charAt(i)+""))
//	    		sa+=s.charAt(i);
//	    }
//	    System.out.println(sa);
        int i=1;
        if(s.contains("\\")){
            System.out.println(s.substring(s.lastIndexOf("\\")+1, s.length())+" "+i);
        }
        else{
            if(s.length()>16)
                System.out.println(s.substring(s.length()-17, s.length())+" "+i);
            else
                System.out.println(s+" "+i);
        }
	}
	
	public static int getMax(int[] array, int start, int end){
//		System.out.println("START: "+start);
//		System.out.println("END: "+end);
        int max=array[start-1];
        for(int i=start; i<end; i++){
            if(max<array[i])
                max=array[i];
        }
        return max;
    }

}
