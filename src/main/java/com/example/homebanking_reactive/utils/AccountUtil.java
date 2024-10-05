package com.example.homebanking_reactive.utils;

public final class AccountUtil {

    public static int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int generateRandomNumber(int max) {
        return (int) (Math.random() * max);
    }

    public static String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < generateRandomNumber(3, 8); i++) {
            accountNumber.append(generateRandomNumber(8));
        };
        return "V-" + accountNumber;
    }

}
