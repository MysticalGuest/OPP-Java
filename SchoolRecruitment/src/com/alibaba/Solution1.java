package com.alibaba;

import java.util.Scanner;

/*
 * 划分：
 * 规定A1如下：
 * [0 1]
 * [1 1]
 * 则An如下：
 * [Bn   An-1]
 * [An-1 An-1]，其中Bn为0矩阵；
 * 根据规律：
 * A2如下：
 * [0 0 0 1]
 * [0 0 1 1]
 * [0 1 0 1]
 * [1 1 1 1]
 * A3如下：
 * [0 0 0 0 0 0 0 1]
 * [0 0 0 0 0 0 1 1]
 * [0 0 0 0 0 1 0 1]
 * [0 0 0 0 1 1 1 1]
 * [0 0 0 1 0 0 0 1]
 * [0 0 1 1 0 0 1 1]
 * [0 1 0 1 0 1 0 1]
 * [1 1 1 1 1 1 1 1]
 * */

public class Solution1 {
	
	/**
	 * @param row 开始划分arr的行
	 * @param col 开始划分arr的列
	 * */
	public static void divide(int [][] arr, int n, int row, int col, int end_r, int end_c) {
		if (n==1) {
//			arr[row][col]=0;
			arr[row][col+1]=1;
			arr[row+1][col]=1;
			arr[row+1][col+1]=1;
			return;
		}
//		for (int i = row; i < end_r; i++) { // 先划分好Bn
//			for (int j = col; j < end_c; j++) {
//				arr[i][j]=0;
//			}
//		}
		// 再划分An
		int pace = (int) Math.pow(2, n-1);
		divide(arr, n-1, row, col+pace, pace, end_c);
		divide(arr, n-1, row+pace, col, end_r, pace);
		divide(arr, n-1, row+pace, col+pace, end_r, end_c);
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int num=(int) Math.pow(2, n);
        
        int[][] a = new int[num][num];
        divide(a, n, 0, 0, num, num);
        for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
    }
}
