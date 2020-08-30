package com.chapter01;

public class StackStructureTest {

    public static void main(String[] args) {
//        int i = 1+2;
        int i = 3;
        int j = 4;
        int k = i+j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }
}
