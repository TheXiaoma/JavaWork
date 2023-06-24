package com.xiaoma.java.classwork.arrayList;

public class ArrayShuffler {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        //随机打乱数组内数据的顺序并输出
        int temp = 0;
        int randomIndex = 0;
        for (int i = 0; i < array.length; i++) {
            randomIndex = (int) (Math.random() * array.length);
            temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
