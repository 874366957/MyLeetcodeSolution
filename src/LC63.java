public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] matrix = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        dfs(obstacleGrid, matrix, 0, 0);
        return matrix[0][0];
    }

    int dfs(int[][] obstacleGrid, Integer[][] matrix, int row, int col) {
        if (matrix[row][col] != null) {
            return matrix[row][col];
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[row][col] == 1) {
            matrix[row][col] = 0;
            return 0;
        }
        int cal;
        if (row == m - 1) {
            cal = dfs(obstacleGrid, matrix, row, col + 1);
        } else if (col == n - 1) {
            cal = dfs(obstacleGrid, matrix, row + 1, col);
        } else {
            cal = dfs(obstacleGrid, matrix, row + 1, col) + dfs(obstacleGrid, matrix, row, col + 1);
        }
        matrix[row][col] = cal;
        return cal;
    }
}
