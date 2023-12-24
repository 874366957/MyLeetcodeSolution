public class LC62 {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[m - 1][n - 1] = 1;
        dfs(0, 0, m, n, matrix);
        return matrix[0][0];
    }

    int dfs(int row, int col, int m, int n, int[][] matrix) {
        if (matrix[row][col] != 0) {
            return matrix[row][col];
        }
        int cal;
        if (row == m - 1) {
            cal = dfs(row, col + 1, m, n, matrix);
        } else if (col == n - 1) {
            cal = dfs(row + 1, col, m, n, matrix);
        } else {
            cal = dfs(row, col + 1, m, n, matrix) + dfs(row + 1, col, m, n, matrix);
        }
        matrix[row][col] = cal;
        return cal;
    }
}
