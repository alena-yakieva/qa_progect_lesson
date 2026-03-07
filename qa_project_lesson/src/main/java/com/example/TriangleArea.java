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

         if (!isValidTriangle(a, b, c)) {
            System.out.println("Треугольник с такими сторонами не существует.");
        } else {
            double area = calculateArea(a, b, c);
            System.out.printf("Площадь треугольника = %.2f%n", area);
        }
        scanner.close();
    }

    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a &&
               a > 0 && b > 0 && c > 0;
    }

    public static double calculateArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

