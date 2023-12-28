import java.util.Arrays;
import java.util.LinkedList;

public class LC918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] matrix = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            matrix[nums.length + i] = matrix[i] = nums[i];
        }
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{0, nums[0]});
        int res = nums[0], preSum = nums[0];
        for (int i = 1; i < matrix.length; ++i) {
            while (!deque.isEmpty() && deque.peekFirst()[0] < i - nums.length) {
                deque.pollFirst();
            }
            preSum += matrix[i];
            res = Math.max(res, preSum - deque.peekFirst()[1]);
            while (!deque.isEmpty() && deque.peekLast()[1] >= preSum) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, preSum});
        }
        return res;
    }
}
