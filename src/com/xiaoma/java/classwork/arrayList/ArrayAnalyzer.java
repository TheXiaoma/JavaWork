package com.xiaoma.java.classwork.arrayList;

import java.util.Random;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        int sum = 0, smallerThanAvg = 0, avg = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            System.out.print(array[i] + " ");
        }
        avg = (int) sum / array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < avg) {
                smallerThanAvg++;
            }
        }
        System.out.println();
        System.out.println("这个数组的所有数据和是: " + sum);
        System.out.println("这个数组的平均值是: " + avg);
        System.out.println("有 " + smallerThanAvg + " 个数据比平均值小");
    }
}