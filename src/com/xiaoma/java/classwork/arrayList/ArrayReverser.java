package com.xiaoma.java.classwork.arrayList;

public class ArrayReverser {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        //让数组array内的元素倒置
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
