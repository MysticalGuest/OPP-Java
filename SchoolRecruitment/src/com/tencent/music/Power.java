 package com.tencent.music;
 
/**
 * @author MysteryGuest
 * @date 2021/04/29
 * 
 * 第二题：
 * 三国鼎立，判断n*m的地图有几股势力
 * 我当时想了一个多小时，没有想到，之后看了群里的讨论
 * 知道了！还是基础不过关，这就是有几个连通图嘛
 * BFS或者DFS啊，这都不会啊
 */
public class Power {
    
    public static int [][]direction = {
        {-1, 0}, // 上
        {1, 0},  // 下
        {0, -1}, // 左
        {0, 1}   // 右
    };
    
    public static int howManyPower(int arr[][]) {
        int r=arr.length;
        if (r==0) {
            return 0;
        }
        int c=arr[0].length;
        int num=0;
        boolean visited[][] = new boolean[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!visited[i][j]) {
                    DFS(arr, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }
    
    /**
     * @param arr: 地图
     * @param (p,q): 遍历起点
     */
    public static void DFS(int arr[][], int p, int q, boolean[][] visited) {
        for (int i = 0; i < direction.length; i++) {
            int x=p+direction[i][0], y=q+direction[i][1];
            if (!outOfBoundary(arr, x, y)) {
                if (arr[p][q]==arr[x][y] && !visited[x][y]) {
                    visited[x][y]=true;
                    DFS(arr, x, y, visited);
                }
            }
        }
    }
    
    public static boolean outOfBoundary(int arr[][], int i, int j) {
        int r=arr.length;
        int c=arr[0].length;
        if (i<0||i>=r||j<0||j>=c) {
            return true;
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] arr = {
            {1,1,2,2},
            {1,2,2,2},
            {3,1,1,1},
            {3,3,3,3}};

        System.out.println(howManyPower(arr));
        
        int [][] arr1 = {
            {1,1,2,2,3},
            {1,2,2,2,1},
            {3,1,1,1,2},
            {3,3,3,3,2}};
        
        System.out.println(howManyPower(arr1));
        
        int [][] arr2 = new int[0][0];
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        System.out.println(howManyPower(arr2));
        
        int [][] arr3 = {
            {1},
            {2},
            {3},
            {3}};
        
        System.out.println(howManyPower(arr3));
        
        int [][] arr4 = {
            {1,1,2,3}};

        System.out.println(howManyPower(arr4));
    }

}
