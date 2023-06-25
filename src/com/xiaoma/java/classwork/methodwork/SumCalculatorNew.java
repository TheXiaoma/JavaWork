package com.xiaoma.java.classwork.methodwork;

public class SumCalculatorNew {

    public static void main(String[] args) {
        System.out.println(getSumNew(114, 256, 4114, 254, 24));
    }

    public static <T extends Number> double getSumNew(T... nums) {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

}
