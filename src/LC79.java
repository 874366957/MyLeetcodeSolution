import java.util.Arrays;

public class LC79 {
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        char[][] matrix = new char[board.length + 2][board[0].length + 2];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], '0');
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                matrix[i + 1][j + 1] = board[i][j];
            }
        }
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    dfs(matrix, i, j, word, 0);
                    if (flag) {
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    void dfs(char[][] matrix, int row, int col, String word, int curr) {
        if (flag) {
            return;
        }
        if (matrix[row][col] == '0') {
            return;
        }
        if (matrix[row][col] != word.charAt(curr)) {
            return;
        }
        if (curr == word.length() - 1) {
            flag = true;
            return;
        }
//        char[][] next = new char[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            next[i] = Arrays.copyOf(matrix[i],matrix[i].length);
//        }
        char temp = matrix[row][col];
        matrix[row][col] = '0';
        dfs(matrix, row + 1, col, word, curr + 1);
        dfs(matrix, row - 1, col, word, curr + 1);
        dfs(matrix, row, col + 1, word, curr + 1);
        dfs(matrix, row, col - 1, word, curr + 1);
        matrix[row][col] = temp;
    }
}
