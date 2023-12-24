import org.junit.Test;

public class LC964 {
    @Test
    public void test() {
        System.out.println(leastOpsExpressTarget(3, 19));
    }


    public int leastOpsExpressTarget(int x, int target) {
        if (target < x) {
            return 2 * target - 1;
        }
        if (target == x) {
            return 0;
        }
        Integer[] matrix = new Integer[target + 1];
        for (int i = 1; i < x; i++) {
            matrix[i] = 2 * i - 1;
        }
        matrix[x] = 0;
        matrix[0] = 0;
        return dfs(x, target, matrix);
    }

    int dfs(int x, int target, Integer[] matrix) {
        if (matrix[target] != null) {
            return matrix[target];
        }
        int j = 1;
        while (Math.pow(x, j) < target) {
            j++;
        }
        if (Math.pow(x, j) == target) {
            matrix[target] = j - 1;
            return j - 1;
        }
        int lower = (int) (target - Math.pow(x, j - 1));
        int upper = (int) (Math.pow(x, j) - target);
        int lowerNext = dfs(x, lower, matrix) + j - 2;
        int upperNext = dfs(x, upper, matrix) + j - 2;
        matrix[target] = Math.min(lowerNext, upperNext);
        return matrix[target];
    }
}
