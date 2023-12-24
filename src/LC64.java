public class LC64 {
    public int minPathSum(int[][] grid) {
        Integer[][] matrix = new Integer[grid.length][grid[0].length];
        matrix[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        dfs(grid, matrix, 0, 0);
        return matrix[0][0];
    }

    int dfs(int[][] grid, Integer[][] matrix, int row, int col) {
        if (matrix[row][col] != null) {
            return matrix[row][col];
        }
        int m = grid.length, n = grid[0].length;
        int cal;
        if (row == m - 1) {
            cal = dfs(grid, matrix, row, col + 1);
        } else if (col == n - 1) {
            cal = dfs(grid, matrix, row + 1, col);
        } else {
            cal = Math.min(dfs(grid, matrix, row + 1, col), dfs(grid, matrix, row, col + 1));
        }
        cal = cal + grid[row][col];
        matrix[row][col] = cal;
        return cal;
    }
}
