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
}

