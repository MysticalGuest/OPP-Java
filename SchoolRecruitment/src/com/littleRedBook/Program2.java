package com.littleRedBook;

import java.util.Scanner;

public class Program2 {
	
	static int maxBoxes(int[][] boxes) {
		int temp1, temp2, min, counter1=1, counter2=1;
		for (int i = 0; i < boxes.length; i++) {
			min=i;
			for (int j = i+1; j < boxes.length; j++) {
				if(boxes[min][0]>boxes[j][0]) {
					min=j;
				}
			}
			if(min!=i) {
				temp1 = boxes[min][0];
				temp2 = boxes[min][1];
				boxes[min][0] = boxes[i][0];
				boxes[min][1] = boxes[i][1];
				boxes[i][0] = temp1;
				boxes[i][1] = temp2;
			}
		}
		for (int i = 0; i < boxes.length; i++) {
			System.out.println( boxes[i][0] + " "+ boxes[i][1] );
		}
		int k=0;
		for (int i = 0; i < boxes.length-1; i++) {
			if(boxes[k][1]<boxes[i+1][1]) {
				counter1++;
				k=i+1;
			}
		}
		k=boxes.length-1;
		for (int i = boxes.length-1; i >0; i--) {
			if(boxes[k][1]>boxes[i-1][1]) {
				counter2++;
				k=i-1;
			}
		}
		return counter1>counter2?counter1:counter2;
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = maxBoxes(_boxes);
        System.out.println(String.valueOf(res));    

    }

}
