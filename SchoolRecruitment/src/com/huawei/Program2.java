package com.huawei;

import java.util.Scanner;

/**
 * 
 * @author MysteryGuest
	标题：满足强迫症
	时间限制：1秒，内存限制：262144K
	小明有一个爱好（强迫症），走路喜欢踩在地砖格上，并且按照固定的步长走。
	某天小明要通过一个未完工的矩形路面，只有部分区域铺设了地砖格，尝试判断小明是否能够按照固定的步长N通过区域。
	输入描述：
		第一行为步长S(S>0),
		第二行为 矩阵的行数M和列数N(0<M, N<=100),
		第三行开始为M*N的矩阵，0表示没有地砖，无法落足，1表示可以落足，小明从左上角出发，要到右下角（这两个位置保证为1）
		样例1中，小明可以沿(0,0)->(0,2)->(2,2)->(2,4)路线到达终点
	输出描述：
		可以通过返回1，否则返回0.
	备注
		每次移动只能沿上下左右方向，不能拐弯或者走斜线，移动不能超出矩形范围，从左上角出发，终点为右下角。

 */

public class Program2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int rectangle[][] = new int[M][N]; 
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				rectangle[i][j]=sc.nextInt();
			}
		}
        int x=0, y=0;
        boolean b = path(rectangle, x, y, M, N, S);
        if(b)
        	System.out.println(1);
        else
        	System.out.println(0);
	}
	
	public static boolean path(int[][] a, int x1, int y1, int m, int n, int step) {
		if(x1==m-1&&y1==n-1)
			return true;
		else if(x1>m-1||y1>n-1) {
			return false;
		} else if(a[x1][y1]==0) {
			return false;
		} else {
			return path(a, x1+step, y1, m, n, step)||path(a, x1, y1+step, m, n, step);
		}
    }

}
