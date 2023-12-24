import java.util.Arrays;

public class LC16 {
    public static void main(String[] args) {
        threeSumClosest(new int[]{1, 1, 1, 0}, -100);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[right] + nums[mid];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < distance) {
                    res = sum;
                    distance = Math.abs(sum - target);
                }
                if (sum < target) {
                    mid++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
