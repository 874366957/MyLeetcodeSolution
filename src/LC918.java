import java.util.Arrays;

public class LC918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] matrix = new int[nums.length * 2 - 1];
        matrix[0] = nums[0];
        int[] newArr = new int[nums.length * 2 - 1];
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        for (int i = nums.length; i < newArr.length; i++) {
            newArr[i] = nums[i - nums.length];
        }
        for (int i = 1; i < newArr.length; i++) {
            matrix[i] = Math.max(matrix[i - 1] + newArr[i], newArr[i]);
        }
        Arrays.sort(matrix);
        return matrix[matrix.length - 1];
    }
}
