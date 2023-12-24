import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class LC1671 {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp1[i] + dp2[nums.length - 1] - 1, res);
        }
        return nums.length - res;
    }
//    public int minimumMountainRemovals(int[] nums) {
//        int times = Integer.MAX_VALUE;
//        for (int i = 1; i < nums.length - 1; i++) {
//            int[] left = Arrays.copyOfRange(nums, 0, i + 1);
//            int[] right = Arrays.copyOfRange(nums, i, nums.length);
//            int i1 = lengthOfLeft(left);
//            int i2 = lengthOfRight(right);
//            if (i1 == 1 || i2 == 1) {
//                continue;
//            }
//            int i3 = nums.length - i1 - i2 + 1;
//            times = Math.min(times, i3);
//        }
//        return times;
//    }

    public int lengthOfLeft(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int lengthOfRight(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[0];
    }

    @Test
    public void test() {
        minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64});
    }
}
