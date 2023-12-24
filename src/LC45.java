import org.junit.Test;

import java.util.Arrays;

public class LC45 {
    public int jump(int[] nums) {
        int[] matrix = new int[nums.length];
        Arrays.fill(matrix, -1);
        matrix[matrix.length - 1] = 0;
        int dfs = dfs(0, nums, matrix);
        return dfs;
    }

    int dfs(int curr, int[] nums, int[] matrix) {
        if (curr == nums.length - 1) {
            return 0;
        }
        if (curr + nums[curr] >= nums.length - 1) {
            matrix[curr] = 1;
            return 1;
        }
        if (nums[curr] == 0 && curr != nums.length - 1) {
            matrix[curr] = 100000;
            return 100000;
        }
        if (matrix[curr] != -1) {
            return matrix[curr];
        }
        int step = 100000;
        for (int i = 1; i <= nums[curr]; i++) {
            step = Math.min(1 + dfs(curr + i, nums, matrix), step);
        }
        matrix[curr] = step;
        return step;
    }

    @Test
    public void test() {
        int jump = jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        System.out.println(jump);
    }
}
