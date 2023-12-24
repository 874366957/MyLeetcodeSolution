import java.util.Arrays;

public class LC198 {
    public int rob(int[] nums) {
        int[] matrix = new int[nums.length + 1];
        for (int i = 1; i < matrix.length; i++) {
            matrix[i] = nums[i - 1];
        }
        return dp(matrix, 0, 0);
    }

    int dp(int[] nums, int curr, int sum) {
        if (curr >= nums.length) {
            return sum;
        }
        sum = sum + nums[curr];
        return Math.max(dp(nums, curr + 1, sum), dp(nums, curr + 2, sum));
    }
}
