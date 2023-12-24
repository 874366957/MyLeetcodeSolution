import java.util.Arrays;

public class LC1901 {
    boolean found = false;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[] res = new int[2];

    public int[] findPeakGrid(int[][] mat) {
        int[][] matrix = new int[mat.length + 2][mat[0].length + 2];
        boolean[][] visited = new boolean[mat.length + 2][mat[0].length + 2];
        for (int i = 1; i <= mat.length; i++) {
            for (int j = 1; j <= mat[0].length; j++) {
                matrix[i][j] = mat[i - 1][j - 1];
            }
        }
        dfs(matrix, 1, 1, visited);
        return res;
    }

    void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (found) {
            return;
        }
        if (check(matrix, row, col)) {
            found = true;
            res = new int[]{row - 1, col - 1};
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = dir[i][0] + row;
            int nextCol = dir[i][1] + col;
            if (matrix[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]) {
                dfs(matrix, nextRow, nextCol, visited);
            }
        }
    }

    boolean check(int[][] matrix, int row, int col) {
        return matrix[row][col] > matrix[row - 1][col] &&
                matrix[row][col] > matrix[row + 1][col] &&
                matrix[row][col] > matrix[row][col - 1] &&
                matrix[row][col] > matrix[row][col + 1];
    }
}
