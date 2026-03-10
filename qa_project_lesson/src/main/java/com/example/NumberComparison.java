package com.example;
import java.util.Scanner;

public class NumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое целое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int num2 = scanner.nextInt();

        System.out.println("Результат сравнения:");

        if (num1 > num2) {
            System.out.println(num1 + " больше " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " меньше " + num2);
        } else {
            System.out.println(num1 + " равно " + num2);
        }

        scanner.close();
    }
<<<<<<< HEAD
=======
    
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
    public static String compareNumbers(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " больше " + num2;
        } else if (num1 < num2) {
            return num1 + " меньше " + num2;
        } else {
            return num1 + " равно " + num2;
        }
    }
}

