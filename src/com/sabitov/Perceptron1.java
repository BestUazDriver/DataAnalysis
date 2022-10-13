package com.sabitov;

import java.util.Arrays;

public class Perceptron1 {
    double[] x;
    double y;
    double[] w;
    double[][] pat = {{0, 0, 0}, {0, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    public static void main(String[] args) {
        new Perceptron1().Perceptron();
    }

    public void Perceptron() {
        x = new double[2];
        w = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            w[i] = Math.random() * 0.2 + 0.1;
            System.out.println("Начальные значения весов");
            System.out.println("w[" + i + "]=" + w[i]);
        }
    }

    public void cy() {
        y = 0;
        for (int i = 0; i < x.length; i++) {
            y += x[i] * w[i];
        }
        System.out.println("Взвешенная сумма входных значений");
        System.out.println(y);
        if (y > 0.5)
            y = 1;
        else
            y = 0;

    }

    public void study() {
        double gEr = 0;
        int m = 0;
        do {
            gEr = 0;
            for (int p = 0; p < pat.length; p++) {
                x = Arrays.copyOf(pat[p], pat[p].length - 1);
                cy();
                double er = pat[p][2] - y;
                gEr += Math.abs(er);
                for (int i = 0; i < x.length; i++) {
                    w[i] += 0.1 * er * x[i];
                }
            }
            m++;
        } while (gEr != 0);
        System.out.println("m=" + m);
    }

    public void test() {
        study();
        for (int p = 0; p < pat.length; p++) {
            x = Arrays.copyOf(pat[p], pat[p].length - 1);
            cy();
            System.out.println("y=" + y);
        }
    }
}

