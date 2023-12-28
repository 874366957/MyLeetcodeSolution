public class LC2735 {
    public long minCost(int[] nums, int x) {
        long ans = (long) 1e14;
        int n = nums.length;
        for (int k = 0; k <= n; k++) //至多“转”n次
        {
            long sum = (long) k * x;
            int tmp = nums[n - 1];
            if (k > 0) {
                for (int i = n - 1; i >= 0; i--) {
                    if (i > 0)
                        nums[i] = Math.min(nums[i], nums[i - 1]);
                    else
                        nums[0] = Math.min(nums[0], tmp);
                    sum += nums[i];
                }
            } else {
                for (int nx : nums) {
                    sum += nx;
                }
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}

