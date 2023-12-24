import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1692 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < piles.length; i++) {
            queue.offer(piles[i]);
        }
        while (k > 0 && queue.peek() > 1) {
            Integer poll = queue.poll();
            queue.offer(poll - poll / 2);
            k--;
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}
