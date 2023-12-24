import java.util.*;

public class LC2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] matrix = new long[n];
        Arrays.fill(matrix, -1L);
        return dfs(n, 0, rides, matrix);
    }

    long dfs(int n, int begin, int[][] rides, long[] matrix) {
        if (begin > n) {
            return 0;
        }
        if (matrix[begin] != -1) {
            return matrix[begin];
        }
        long distance = 0;
        for (int i = 0; i < rides.length; i++) {

            if (rides[i][0] >= begin) {
                int value = rides[i][1] + rides[i][2] - rides[i][0];
                distance = Math.max(distance, value + dfs(n, rides[i][1], rides, matrix));
            }
        }
        matrix[begin] = distance;
        return distance;
    }
}
