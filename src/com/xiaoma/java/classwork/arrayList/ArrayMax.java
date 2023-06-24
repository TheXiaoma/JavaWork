package com.xiaoma.java.classwork.arrayList;

public class ArrayMax {
    public static void main(String[] args) {
        int[] array = {33, 5, 22, 44, 55};
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
