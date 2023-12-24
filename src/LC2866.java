import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC2866 {
    //TODO 单调栈用法
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] matrix1 = new long[maxHeights.size()];
        long[] matrix2 = new long[maxHeights.size()];
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && maxHeights.get(stack1.peekFirst()) < maxHeights.get(i)) {

            }
            if (stack1.isEmpty()) {
                stack1.push(i);
            }
        }
        return 0;
    }
}
