package com.sabitov.regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final String path = "src\\com\\sabitov\\resources\\USDJPY_220904_221004.txt";
    private static BufferedReader bufferedReader;

    public static void main(String[] args) {
        model1();
        model2();
        model3();
        model4();
    }

    static void model1() {
        double x = 0;
        double x2 = 0;
        double xy = 0;
        int y = 0;
        int time = 0;
        try {
            String line;
            int n = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            System.out.println(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null) {
                time++;
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                x += time;
                x2 += time * time;
                n++;
                y += close;
                xy += close * time;
            }
            double xx = x / n;
            double xx2 = x2 / n;
            int yy = y / n;
            double xxyy = xy / n;
            double b1 = (xxyy - xx * yy) / (xx2 - xx * xx);
            double b0 = yy - b1 * xx;
            double r2 = determinant(b0, b1, xx);
            System.out.println("\nC= " + b0 + " + " + b1 + "*t + e ; R = " + r2);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void model2() {
        double x = 0;
        double x2 = 0;
        double xy = 0;
        double y = 0;
        try {
            String line;
            int n = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double open = Double.parseDouble(array[2]);
                x += open;
                x2 += open * open;
                n++;
                y += close;
                xy += close * open;
            }
            double xx = x / n;
            double xx2 = x2 / n;
            double yy = y / n;
            double xxyy = xy / n;
            double b1 = (xxyy - xx * yy) / (xx2 - xx * xx);
            double b0 = yy - b1 * xx;
            double r2 = determinant(2, b0, b1, xx);
            System.out.println("\nC = " + b0 + " + " + b1 + "*O + e ; R = " + r2);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void model3() {
        double x = 0;
        double x2 = 0;
        double xy = 0;
        double y = 0;
        try {
            String line;
            int n = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double low = Double.parseDouble(array[4]);
                x += low;
                x2 += low * low;
                n++;
                y += close;
                xy += close * low;
            }
            double xx = x / n;
            double xx2 = x2 / n;
            double yy = y / n;
            double xxyy = xy / n;
            double b1 = (xxyy - xx * yy) / (xx2 - xx * xx);
            double b0 = yy - b1 * xx;
            double r2 = determinant(4, b0, b1, xx);
            System.out.println("\nC= " + b0 + " + " + b1 + "*L + e ; R = " + r2);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void model4() {
        BufferedReader bufferedReader;
        double x = 0;
        double x2 = 0;
        double xy = 0;
        double y = 0;
        try {
            String line;
            int n = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double high = Double.parseDouble(array[3]);
                x += high;
                x2 += high * high;
                n++;
                y += close;
                xy += close * high;
            }
            double xx = x / n;
            double xx2 = x2 / n;
            double yy = y / n;
            double xxyy = xy / n;
            double b1 = (xxyy - xx * yy) / (xx2 - xx * xx);
            double b0 = yy - b1 * xx;
            double r2 = determinant(3, b0, b1, xx);
            System.out.println("\nC= " + b0 + " + " + b1 + "*H + e ; R = " + r2);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void model5() {
        double x = 0;
        double x2 = 0;
        double xy1 = 0;
        double xy2 = 0;
        double y1 = 0;
        double y2 = 0;
        try {
            String line;
            int n = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double high = Double.parseDouble(array[3]);
                double open = Double.parseDouble(array[2]);
                x += close;
                x2 += close * close;
                n++;
                y1 += high;
                y2 += open;
                xy1 += close * high;
                xy2 += close * open;
            }

            double xx = x / n;
            double xx2 = x2 / n;
            double yy1 = y1 / n;
            double yy2 = y2 / n;
            double xxyy1 = xy1 / n;
            double xxyy2 = xy2 / n;
            double b1 = (xxyy1 - xx * yy1) / (xx2 - xx * xx);
            double b2 = (xxyy2 - xx * yy2) / (xx2 - xx * xx);
            double b01 = yy1 - b1 * xx;
            double b02 = yy2 - b2 * xx;
            double c1 = b01 + b1;
            double c2 = b02 + b2;
            System.out.println("\nC = " + c1 + "*H + " + c2 + "*O + e");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static double determinant(int y, double b0, double b1, double yy) {
        double determinant;
        double ee = 0;
        try {
            String line;
            double cc = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double param = Double.parseDouble(array[y]);
                double cci = b0 + b1 * close;
                ee += (param - cci) * (param - cci);
                cc += (param - yy) * (param - yy);
            }
            determinant = Math.sqrt(1 - (ee / cc));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return determinant;
    }

    private static double determinant(double b0, double b1, double xx) {
        double determinant;
        double ee = 0;
        try {
            String line;
            double cc = 0;
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            int n = 0;
            while ((line = bufferedReader.readLine()) != null) {
                n++;
                String[] array = line.split(",");
                double close = Double.parseDouble(array[5]);
                double param = n;
                double cci = b0 + b1 * close;
                ee += (param - cci) * (param - cci);
                cc += (param - xx) * (param - xx);
            }
            determinant = Math.sqrt(1 - (ee / cc));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return determinant;
    }


}
