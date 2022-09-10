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
}
