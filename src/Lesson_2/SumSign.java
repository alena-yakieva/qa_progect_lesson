package Lesson_2;

public class SumSign {
    public static void checkSumSign() {
        int a = 5;
        int b = 15;
        int c = (a + b);
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
        public static void main(String[] args) {
            checkSumSign();
        }

    }

