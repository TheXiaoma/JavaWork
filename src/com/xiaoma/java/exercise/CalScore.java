package com.xiaoma.java.exercise;

import java.util.Scanner;

public class CalScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] unfilteredScore = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个评分：");
            unfilteredScore[i] = scanner.nextInt();
        }
        int arrayMax = unfilteredScore[0];
        int arrayMin = unfilteredScore[0];
        int arraySum = unfilteredScore[0];
        double finalScore = 0;
        for (int i = 1; i < unfilteredScore.length; i++) {
            if (unfilteredScore[i] > arrayMax) arrayMax = unfilteredScore[i];
            else if (unfilteredScore[i] < arrayMin) arrayMin = unfilteredScore[i];
            arraySum += unfilteredScore[i];
        }
        finalScore = (double) (arraySum - arrayMax - arrayMin) / 4;
        System.out.println(finalScore);
    }
}
