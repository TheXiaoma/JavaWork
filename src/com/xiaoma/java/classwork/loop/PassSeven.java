package com.xiaoma.java.classwork.loop;

public class PassSeven {
    public static void main(String[] args) {
        /*
        逢七过
        当输出的数字当中包含7或被7整除时，说"过"
         */

        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.println("过");
            } else {
                System.out.println(i);
            }
        }
    }
}
