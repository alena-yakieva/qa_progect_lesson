package Lesson_2;

public class LeapYear {
    public static void printLeapYear() {
        int year = 2026;
        if (year % 400 == 0) {
            System.out.println("true");
        } else if (year % 100 == 0) {
            System.out.println("false");
        } else if (year % 4 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        printLeapYear();
    }
}
