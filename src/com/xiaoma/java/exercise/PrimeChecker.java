package com.xiaoma.java.exercise;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countedPrimes = 0;
        for (int i = 101; i <= 200; i++) {
            if (checkPrime(i) == true) {
                System.out.println(i);
                countedPrimes++;
            }
        }
        System.out.println("101-200中共有: " + countedPrimes + " 个质数");
    }

    public static boolean checkPrime(int number) {
        int i = 2;
        for (int i1 = 0; i1 < number - 2; i1++) {
            if (number % i == 0) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
