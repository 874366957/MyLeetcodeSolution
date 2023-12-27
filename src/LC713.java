public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, res = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= prod * nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            res = res + j - i + 1;
        }
        return res;
    }
}
