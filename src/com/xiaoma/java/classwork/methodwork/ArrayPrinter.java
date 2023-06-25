package com.xiaoma.java.classwork.methodwork;

public class ArrayPrinter {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printArray(array);
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
