import org.junit.Test;

import java.util.Arrays;

public class LC746 {
    int res = Integer.MAX_VALUE;

    public int minCostClimbingStairs(int[] cost) {
        int[] matrix = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            matrix[i + 1] = cost[i];
        }
        dp(matrix, 0, 0);
        return res;
    }

    void dp(int[] cost, int sum, int curr) {
        if (curr >= cost.length) {
            res = Math.min(sum, res);
            return;
        }
        dp(cost, sum + cost[curr], curr + 1);
        dp(cost, sum + cost[curr], curr + 2);
    }

    @Test
    public void test() {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
