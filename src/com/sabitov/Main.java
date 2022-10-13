package com.sabitov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        int n = scanner.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = random.nextInt(20);
                matrix2[i][j] = random.nextInt(20);
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println("");
        }
        long startTime = System.nanoTime();
        System.out.println(Arrays.deepToString(squareMatrixMultiply(matrix1, matrix2)));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration + " milliseconds");

        long startTime1 = System.nanoTime();
        System.out.println(Arrays.deepToString(squareMatrixMultiply2(matrix1, matrix2)));
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("Time: " + duration1 + " milliseconds");
        long startTime2 = System.nanoTime();
        System.out.println(Arrays.deepToString(squareMatrixMultiply3(matrix1, matrix2)));
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("Time: " + duration2 + " milliseconds");
    }

    private static int[][] squareMatrixMultiply(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int n = 0; n < matrix.length; n++) {
                    matrix[i][j] += matrix1[i][n] * matrix2[n][j];
                }
            }
        }
        return matrix;
    }

    private static int[][] squareMatrixMultiply2(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix2.length];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int n = 0; n < matrix.length; n++) {
                    matrix[i][j] += matrix1[i][n] * matrix2[n][j];
                }
            }
        }
        return matrix;
    }

    private static int[][] squareMatrixMultiply3(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int n = 0; n < matrix.length; n++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] += matrix1[i][n] * matrix2[n][j];
                }
            }
        }
        return matrix;
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
            if (result[i]==null){
                result[i]="i";
            }
        }
        return result;
    }

}
