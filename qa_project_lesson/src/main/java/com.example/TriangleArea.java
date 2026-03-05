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

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Треугольник с такими сторонами не существует.");
        } else {
            double p = (a + b + c) / 2;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.printf("Площадь треугольника = %.2f%n", area);
        }
        scanner.close();
    }
}

