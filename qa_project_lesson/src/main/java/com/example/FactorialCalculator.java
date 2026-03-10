package com.example;
import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для вычисления факториала: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Факториал отрицательного числа не существует.");
        } else {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("Факториал числа " + n + " = " + factorial);
        }
        scanner.close();
    }
<<<<<<< HEAD
     public static long calculateFactorial(int n) {
=======

    public static long calculateFactorial(int n) {
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не существует.");
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
<<<<<<< HEAD

=======
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
