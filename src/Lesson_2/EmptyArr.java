package Lesson_2;

import java.util.Arrays;

public class EmptyArr {
    public static void main(String[] args) {
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i +1;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
