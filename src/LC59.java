public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        dfs(matrix, 1, 0, 0, 1);
        return matrix;
    }

    void dfs(int[][] matrix, int cur, int row, int col, int direction) {
        matrix[row][col] = cur;
        if (checkIsFilled(matrix)) {
            return;
        }
        int[] dir = calDirection(matrix, row, col, direction);
        dfs(matrix, cur + 1, dir[0], dir[1], dir[2]);
    }

    int[] calDirection(int[][] matrix, int x, int y, int direction) {
        int n = matrix.length;
        int nextx = x, nexty = y;
        if (direction == 1) {
            if (nexty + 1 >= n || matrix[nextx][nexty + 1] != 0) {
                return new int[]{nextx + 1, nexty, changeDirection(1)};
            }
            return new int[]{nextx, nexty + 1, 1};
        }
        if (direction == 2) {
            if (nextx + 1 >= n || matrix[nextx + 1][nexty] != 0) {
                return new int[]{nextx, nexty - 1, changeDirection(2)};
            }
            return new int[]{nextx + 1, nexty, 2};
        }
        if (direction == 3) {
            if (nexty - 1 < 0 || matrix[nextx][nexty - 1] != 0) {
                return new int[]{nextx - 1, nexty, changeDirection(3)};
            }
            return new int[]{nextx, nexty - 1, 3};
        } else {
            if (nextx - 1 < 0 || matrix[nextx - 1][nexty] != 0) {
                return new int[]{nextx, nexty + 1, changeDirection(0)};
            }
            return new int[]{nextx - 1, nexty, 0};
        }
    }

    int changeDirection(int x) {
        return x == 3 ? 0 : x + 1;
    }

    boolean checkIsFilled(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
