import org.junit.Test;

public class LC55 {
    public boolean canJump(int[] nums) {
        Boolean[] matrix = new Boolean[nums.length];
        dfs(matrix, nums, 0);
        return matrix[0];
    }

    boolean dfs(Boolean[] matrix, int[] nums, int curr) {
        if (curr + nums[curr] >= nums.length - 1) {
            matrix[curr] = true;
            return true;
        }
        if (curr < nums.length - 1 && nums[curr] == 0) {
            matrix[curr] = false;
            return false;
        }
        if (matrix[curr] != null) {
            return matrix[curr];
        }
        for (int i = 1; i <= nums[curr]; i++) {
            boolean flag = dfs(matrix, nums, curr + i);
            if (flag) {
                matrix[curr] = true;
                return true;
            }
        }
        matrix[curr] = false;
        return false;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
