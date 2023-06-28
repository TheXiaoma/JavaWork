package com.xiaoma.java.exercise;

import java.util.Random;

public class VerifyCodeGenerator {
    public static void main(String[] args) {
        System.out.println(generateVerifyCode());
    }

    public static String generateVerifyCode() {
        Random random = new Random();
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] numberList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String verifyCode = "";
        int randomIndex = 0;
        for (int i = 0; i < 4; i++) {
            randomIndex = random.nextInt(alphabet.length);
            verifyCode += alphabet[randomIndex];
        }
        randomIndex = random.nextInt(numberList.length);
        verifyCode += numberList[randomIndex];
        return verifyCode;
    }
}
