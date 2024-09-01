package BT1;

import java.util.Scanner;

public class AverageCalculator {
    public static final int NUM_COUNT = 5;
    public static void main(String[] args) {
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_COUNT; i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            int num = scanner.nextInt();
            total += num;
        }
        scanner.close();
        double average = (double) total / NUM_COUNT;
        System.out.println("Giá trị trung bình của " + NUM_COUNT + " số nguyên đã nhập là: " + average);
    }
}

