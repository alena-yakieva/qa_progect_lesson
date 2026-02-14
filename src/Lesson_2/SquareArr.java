package Lesson_2;

public class SquareArr {
    public static void main(String[] args) {
        int[][] table = new int[12][12];
        for (int i = 0; i < 12; i++) {
            table[i][i] = 1;
            table[i][12 - i - 1] = 1;
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    }
}
