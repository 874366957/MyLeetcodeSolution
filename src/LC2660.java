import java.util.Arrays;

public class LC2660 {
    public int isWinner(int[] player1, int[] player2) {
        int[] matrix1 = new int[player1.length + 2];
        int[] matrix2 = new int[player2.length + 2];
        for (int i = 0; i < player1.length; i++) {
            matrix1[i + 2] = player1[i];
        }
        for (int i = 0; i < player2.length; i++) {
            matrix2[i + 2] = player2[i];
        }
        int sum1 = 0;
        for (int i = 2; i < matrix1.length; i++) {
            if (matrix1[i - 1] == 10 || matrix1[i - 2] == 10) {
                sum1 = sum1 + 2 * matrix1[i];
            } else {
                sum1 = sum1 + matrix1[i];
            }
        }

        int sum2 = 0;
        for (int i = 2; i < matrix2.length; i++) {
            if (matrix2[i - 1] == 10 || matrix2[i - 2] == 10) {
                sum2 = sum2 + 2 * matrix2[i];
            } else {
                sum2 = sum2 + matrix2[i];
            }
        }
        if (sum1 > sum2) {
            return 1;
        } else if (sum2 > sum1) {
            return 2;
        } else {
            return 0;
        }
    }
}
