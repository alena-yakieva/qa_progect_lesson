package com.example;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину первой стороны треугольника: ");
        double a = scanner.nextDouble();
        System.out.print("Введите длину второй стороны треугольника: ");
        double b = scanner.nextDouble();
        System.out.print("Введите длину третьей стороны треугольника: ");
        double c = scanner.nextDouble();

<<<<<<< HEAD
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Треугольник с такими сторонами не существует.");
        } else {
            double p = (a + b + c) / 2;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
=======
         if (!isValidTriangle(a, b, c)) {
            System.out.println("Треугольник с такими сторонами не существует.");
        } else {
            double area = calculateArea(a, b, c);
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
            System.out.printf("Площадь треугольника = %.2f%n", area);
        }
        scanner.close();
    }
<<<<<<< HEAD
=======

>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a &&
               a > 0 && b > 0 && c > 0;
    }

    public static double calculateArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

