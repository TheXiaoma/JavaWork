package com.xiaoma.java.classwork.methodwork;

public class ArrayMaxFinder {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(findArrayMax(array));
    }

    public static int findArrayMax(int[] inputArray) {
        int arrayMax = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (arrayMax < inputArray[i]) {
                arrayMax = inputArray[i];
            }
        }
        return arrayMax;
    }
}