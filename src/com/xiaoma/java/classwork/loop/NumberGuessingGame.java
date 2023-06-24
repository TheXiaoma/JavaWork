package com.xiaoma.java.classwork.loop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("欢迎来到猜数字游戏");
        while (true) {
            int answer = random.nextInt(100);
            for (int i = 1; i < 6; i++) {
                System.out.print("请输入你猜的数字(1-100): ");
                int input = scanner.nextInt();
                if (input == answer) {
                    System.out.println("恭喜你猜对了");
                    break;
                } else if (input > answer) {
                    System.out.println("你猜的数字大了");
                } else {
                    System.out.println("你猜的数字小了");
                }
                if (i == 5) {
                    System.out.println("很遗憾，你没有猜对，正确答案是 " + answer);
                }
            }
            System.out.print("是否继续游戏(y/n): ");
            String choice = scanner.next();
            if (choice.equals("n")) {
                break;
            }
        }
        scanner.close();
    }
}