package com.xiaoma.java.classwork.methodwork;

public class ArrayChecker {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int valve = 3;
        System.out.println(containsCheck(array, valve));
    }

    public static boolean containsCheck(int[] inputArray, int containsValve) {
        for (int i = 0; i < inputArray.length; i++) {
            if (containsValve == inputArray[i]) {
                return true;
            }
        }
        return false;
    }
}
