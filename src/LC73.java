public class LC73 {
    public void setZeroes(int[][] matrix) {
        boolean[][] isOriginal = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    isOriginal[i][j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isOriginal[i][j]) {
                    for (int x = 0; x < matrix.length; x++) {
                        matrix[x][j] = 0;
                    }
                    for (int x = 0; x < matrix[0].length; x++) {
                        matrix[i][x] = 0;
                    }
                }
            }
        }
    }
}
