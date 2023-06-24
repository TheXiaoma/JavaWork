package com.xiaoma.java.classwork.loop;

import java.text.MessageFormat;
import java.util.Scanner;

public class SqrtSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入欲求平方根的数字：");
            double num = scanner.nextDouble();
            if (num <= 2) {
                System.out.println("请输入大于2的数字");
                continue;
            } else if (num > 1e9) {
                System.out.println("请输入小于1*10^9的数字");
                continue;
            }
            int i = 1;
            while (i * i < num) {
                i++;
            }
            if (i * i == num) {
                System.out.println(i);
                System.out.println(MessageFormat.format("{0} 的平方根为: {1}", num, i));
            } else {
                System.out.println(MessageFormat.format("{0} 的平方根的整数部分为: {1}", num, i - 1));
            }
        }
    }
}