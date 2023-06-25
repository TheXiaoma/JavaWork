package com.xiaoma.java.classwork.array;

public class ArrayTransformer {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[i] *= 2;
            } else {
                array[i] /= 2;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
