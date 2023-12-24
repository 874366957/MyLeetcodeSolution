public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int curr = 0;
        while (curr < matrix.length && target > matrix[curr][n - 1]) {
            curr++;
        }
        if (n == 1) {
            return target == matrix[curr][0];
        }
        boolean exist = false;
        int lcurr = 0, rcurr = n - 1;
        while (lcurr <= rcurr) {
            int mid = (lcurr + rcurr) / 2;
            if (matrix[curr][mid] == target) {
                exist = true;
                break;
            } else if (target < matrix[curr][mid]) {
                rcurr = mid - 1;
            } else {
                lcurr = mid + 1;
            }
        }
        return exist;
    }
}
