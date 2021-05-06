 package com.tencent.music;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author MysteryGuest
 * @date 2021/04/29
 */
public class Program1 {
    
    public int minPay(int []arr) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], 1);
            }
            else {
                int num=hashMap.get(arr[i])+1;
                hashMap.replace(arr[i], num);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i])==1&&min>arr[i]) {
                min=arr[i];
            }
        }
        if (min==Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Program1 program1 = new Program1();
        
        int a[] = {1,1,4,5,5};
        System.out.println(program1.minPay(a));
        
        int a1[] = {1,1};
        System.out.println(program1.minPay(a1));
        
        int a2[] = {1,2,3};
        System.out.println(program1.minPay(a2));

    }

}
