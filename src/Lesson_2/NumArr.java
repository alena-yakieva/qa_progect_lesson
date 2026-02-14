package Lesson_2;

import java.util.Arrays;

public class NumArr {
    public static void main(String[] args) {
        int [] nums = {0,1,1,0,0,1,1,0,0,1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
