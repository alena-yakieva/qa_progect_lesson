package Lesson_2;

import java.util.Arrays;

public class EmptyArr {
    public static void main(String[] args) {
        int [] arr = new int[101];
        for (int i = 0; i <= 100; i++) {
            arr[i] = i;
        }
            System.out.println(Arrays.toString(arr));

    }
}
