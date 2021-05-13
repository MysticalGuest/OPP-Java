 package com.tencent.music;

import java.util.HashMap;

/**
 * @author MysteryGuest
 * @date 2021/04/29
 * 
 * 共3道编程题，第一道所有用例通过
 * 回忆：应该是涉及奖金，根据每个员工的想法分奖金，每个员工提出想分多少钱，从所有员工钱数中选取最小值，
 * 为了避免员工商量，出现同样的钱数，所以舍弃相同钱数的方案，如果所有员工心里想的钱数一样，则返回-1
 */
public class MinAward {
    
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
        MinAward program1 = new MinAward();
        
        int a[] = {1,1,4,5,5};
        System.out.println(program1.minPay(a));
        
        int a1[] = {1,1};
        System.out.println(program1.minPay(a1));
        
        int a2[] = {1,2,3};
        System.out.println(program1.minPay(a2));

    }

}
