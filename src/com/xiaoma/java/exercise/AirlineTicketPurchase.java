package com.xiaoma.java.exercise;

import java.util.Scanner;

public class AirlineTicketPurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入机票原价: ");
        double normalPrice = scanner.nextDouble();

        System.out.print("输入购票月份 ");
        int boughtMonth = scanner.nextInt();

        System.out.print("输入舱位等级 ");
        String seatLevel = scanner.next();

        double dismont = 0.0;

        switch (boughtMonth) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                if (seatLevel == "头等舱") {
                    dismont = 0.9;
                } else {
                    dismont = 0.85;
                }
                break;
            default:
                if (seatLevel == "头等舱") {
                    dismont = 0.7;
                } else {
                    dismont = 0.65;
                }
                break;
        }
        System.out.println("机票价格为: " + normalPrice * dismont);
    }
}
