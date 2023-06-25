package com.xiaoma.java.classwork.methodwork;

public class ArrayCopier {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayPrinter.printArray(copyArray(arr, 1, 3));
    }

    public static int[] copyArray(int[] inputArray, int startIndex, int endIndex) {
        int[] newArray = new int[endIndex - startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            newArray[i - startIndex] = inputArray[i];
        }
        return newArray;
    }
}
