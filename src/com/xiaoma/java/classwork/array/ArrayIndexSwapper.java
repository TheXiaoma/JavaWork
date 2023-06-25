package com.xiaoma.java.classwork.array;

public class ArrayIndexSwapper {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int temp = 0;
        temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
