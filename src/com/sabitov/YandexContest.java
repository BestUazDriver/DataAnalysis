package com.sabitov;

import java.util.Arrays;
import java.util.Scanner;

public class YandexContest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String alice = scanner.nextLine();
//        String bob = scanner.nextLine();
//        System.out.println(Arrays.toString(plug(alice, bob)));
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int r = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println(bottles(b, c, r, d));
    }

    private static String[] plug(String alice, String bob) {
        String[] result = new String[bob.length()];
        for (int i = 0; i < bob.length(); i++) {
            if (bob.charAt(i) == alice.charAt(i)) {
                result[i] = "p";
            }
        }
        for (int i = 0; i < bob.length(); i++) {
            if (result[i] == null) {
                for (int j = 0; j < alice.length(); j++) {
                    if (result[j] == null && alice.charAt(j) == bob.charAt(i)) {
                        result[i] = "s";
                    }
                }
            }
        }
        for (int i = 0; i < bob.length(); i++) {
            if (result[i] == null) {
                result[i] = "i";
            }
        }
        return result;
    }

    private static int bottles(int millions, int rubles, int r, int d) {
        int result = millions / r;
        int left = millions % r + rubles;
        return result + left/r;
    }
}
