package com.xiaoma.java.exercise;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int num = scanner.nextInt();
        int[] digits = new int[String.valueOf(num).length()];
        int i = 0;
        while (num > 0) {
            digits[i] = (num % 10 + 5) % 10;
            num /= 10;
            i++;
        }
        int reversedNum = 0;
        int weight = 1;
        for (int j = digits.length - 1; j >= 0; j--) {
            reversedNum += digits[j] * weight;
            weight *= 10;
        }
        String reversedNumStr = String.format("%0" + digits.length + "d", reversedNum);
        System.out.println("The reversed number is: " + reversedNumStr);
    }
}