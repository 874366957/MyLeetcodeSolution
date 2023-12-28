import java.util.LinkedList;

public class LC2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        long sum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        int lcurr = 0, rcurr = 0;
        while (rcurr < chargeTimes.length) {
            while (!queue.isEmpty() && chargeTimes[rcurr] >= chargeTimes[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(rcurr);
            sum = sum + runningCosts[rcurr];
            while (!queue.isEmpty() && (rcurr - lcurr + 1) * sum + chargeTimes[queue.peek()] > budget) {
                if (queue.peek() == lcurr) {
                    queue.poll();
                }
                sum = sum - runningCosts[lcurr];
                lcurr++;
            }
            ans = Math.max(ans, rcurr - lcurr + 1);
            rcurr++;
        }
        return ans;
    }
}
