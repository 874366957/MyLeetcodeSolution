import java.lang.reflect.Field;
import java.util.Arrays;

public class LC37 {
    public void solveSudoku(char[][] board) {
        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    matrix[i][j] = board[i][j] - '0';
                }
            }
        }
        dfs(matrix);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (matrix[i][j] + '0');
            }
        }
    }

    boolean dfs(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    boolean flag = checkIsUsed(matrix, i, j, k);
                    if (flag) {
                        continue;
                    }
                    if (dfs(matrix)) {
                        return true;
                    }
                    matrix[i][j] = 0;
                }
                return false;
            }
        }
        return true;
    }

    private boolean checkIsUsed(int[][] matrix, int i, int j, int k) {
        for (int n = 0; n < 9; n++) {
            if (matrix[n][j] == k) {
                return false;
            }
        }
        for (int n = 0; n < 9; n++) {
            if (matrix[i][n] == k) {
                return false;
            }
        }
        int xmat = i / 3;
        int ymat = j / 3;
        for (int x = xmat * 3; x < xmat * 3 + 3; x++) {
            for (int y = ymat * 3; y < ymat * 3 + 3; y++) {
                if (matrix[x][y] == k) {
                    return false;
                }
            }
        }
        return true;
    }

}
