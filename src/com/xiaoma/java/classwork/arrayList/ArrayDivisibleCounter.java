package com.xiaoma.java.classwork.arrayList;

public class ArrayDivisibleCounter {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
