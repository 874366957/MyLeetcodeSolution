public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        int[][][] matrix = new int[9][9][10];
        int[][][] part = new int[3][3][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                for (int k = 0; k < i; k++) {
                    if (matrix[k][j][ch - '0'] > 0) {
                        return false;
                    }
                }
                for (int k = 0; k < j; k++) {
                    if (matrix[i][k][ch - '0'] > 0) {
                        return false;
                    }
                }
                int x = i / 3;
                int y = j / 3;
                if (part[x][y][ch - '0'] > 0) {
                    return false;
                }
                matrix[i][j][ch - '0']++;
                part[x][y][ch - '0']++;
            }
        }
        return true;
    }
}
