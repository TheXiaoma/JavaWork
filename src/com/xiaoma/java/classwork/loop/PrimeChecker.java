package com.xiaoma.java.classwork.loop;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPrime = true;
        while (true) {
            System.out.println("请输入一个正整数:");
            int input = scanner.nextInt();
            for (int i = 2; i < input; i++) {
                if (input % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(input + "是质数");
            } else {
                System.out.println(input + "不是质数");
            }
        }
    }
}