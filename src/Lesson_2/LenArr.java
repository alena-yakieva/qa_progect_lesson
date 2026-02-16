package Lesson_2;

import java.util.Arrays;

public class LenArr {
    public static void printLen() {
        int len = 7;
        int initialValue = 5;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        printLen();
    }
}
