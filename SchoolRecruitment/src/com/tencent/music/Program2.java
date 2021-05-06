 package com.tencent.music;
 
/**
 * @author MysteryGuest
 * @date 2021/04/29
 * 
 * 三国鼎立，判断n*m的地图有几股势力
 * 我当时想了一个多小时，没有想到，之后看了群里的讨论
 * 知道了！还是基础不过关，这就是有几个连通图嘛
 * BFS或者DFS啊，这都不会啊
 */
public class Program2 {
    
    static boolean visited[][];
    public static int [][]direction = {
        {-1, 0}, // 上
        {1, 0},  // 下
        {0, -1}, // 左
        {0, 1}   // 右
    };
    
    public static int howManyPower(int arr[][]) {
        
    }
    
    /**
     * @param arr: 地图
     * @param (p,q): 遍历起点
     */
    public static void DFS(int arr[][], int p, int q) {
        for (int i = 0; i < direction.length; i++) {
            int x=p+direction[i][0], y=q+direction[i][1];
            if (!outOfBoundary(arr, x, y)) {
                if (arr[p][q]==arr[x][y] && !visited[x][y]) {
                    DFS(arr, x, y);
                }
            }
        }
    }
    
    public static boolean outOfBoundary(int arr[][], int i, int j) {
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] arr = {{1,1,2,2},
            {1,2,2,2},
            {3,1,1,1},
            {3,3,3,3}};

        howManyPower(arr);
    }

}
