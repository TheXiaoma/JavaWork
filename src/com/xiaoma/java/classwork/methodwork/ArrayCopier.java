package com.xiaoma.java.classwork.methodwork;

public class ArrayCopier {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printArray(copyArray(arr, 1, 3));
    }

    public static int[] copyArray(int[] inputArray, int startIndex, int endIndex) {
        int[] newArray = new int[endIndex - startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            newArray[i - startIndex] = inputArray[i];
        }
        return newArray;
    }

    public static void printArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (i == 0) {
                System.out.print("[ " + inputArray[i] + " , ");
            } else if (i == inputArray.length - 1) {
                System.out.println(inputArray[i] + " ]");
            } else {
                System.out.print(inputArray[i] + " , ");
            }
        }
    }
}
