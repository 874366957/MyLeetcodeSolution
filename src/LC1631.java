import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    private static int diff(int a, int b) {
        return (int) Math.abs((long) a - b);
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        while (!que.isEmpty()) {
            int[] cur = que.pollFirst();
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k], y = cur[1] + dy[k];
                int newVal;
                if (0 <= x && x < m && 0 <= y && y < n
                        && (!visited[x][y] |
                        (newVal = Math.max(dp[cur[0]][cur[1]], diff(heights[x][y], heights[cur[0]][cur[1]]))) < dp[x][y])) {
                    visited[x][y] = true;
                    que.add(new int[]{x, y});
                    dp[x][y] = newVal;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
