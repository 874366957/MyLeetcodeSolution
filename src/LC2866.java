import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC2866 {
    //TODO 单调栈用法
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] res = new long[maxHeights.size()];
        for (int i = 0; i < maxHeights.size(); i++) {
            LinkedList<Integer> stack1 = new LinkedList<>();
            LinkedList<Integer> stack2 = new LinkedList<>();
            int lcurr = i;
            long lsum = 0;
            while (lcurr >= 0) {
                if (stack1.isEmpty()) {
                    lsum = lsum + maxHeights.get(lcurr);
                    stack1.push(lcurr);
                } else {
                    if (maxHeights.get(stack1.peek()) <= maxHeights.get(lcurr)) {
                        lsum = lsum + maxHeights.get(stack1.peek());
                    } else {
                        lsum = lsum + maxHeights.get(lcurr);
                        stack1.push(lcurr);
                    }
                }
                lcurr--;
            }
            int rcurr = i;
            long rsum = 0;
            while (rcurr < maxHeights.size()) {
                if (stack2.isEmpty()) {
                    rsum = rsum + maxHeights.get(rcurr);
                    stack2.push(rcurr);
                } else {
                    if (maxHeights.get(stack2.peek()) <= maxHeights.get(rcurr)) {
                        rsum = rsum + maxHeights.get(stack2.peek());
                    } else {
                        rsum = rsum + maxHeights.get(rcurr);
                        stack2.push(rcurr);
                    }
                }
                rcurr++;
            }
            res[i] = lsum + rsum - maxHeights.get(i);
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }
}
