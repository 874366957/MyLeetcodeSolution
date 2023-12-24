import org.junit.Test;

import java.util.*;

public class LC1054 {
    @Test
    public void test() {
        rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        TreeMap<Integer, Integer> cache = new TreeMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            cache.put(barcodes[i], cache.getOrDefault(barcodes[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        queue.addAll(cache.entrySet());
        int[] matrix = new int[barcodes.length + 2];
        Arrays.fill(matrix, -1);
        while (queue.peek().getValue() != 0) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            Integer key = poll.getKey();
            for (int i = 1; i < matrix.length - 1; i++) {
                if (matrix[i] == -1 && (matrix[i - 1] != key && matrix[i + 1] != key)) {
                    matrix[i] = key;
                    poll.setValue(poll.getValue() - 1);
                    break;
                }
            }
            queue.offer(poll);
        }
        int[] res = new int[barcodes.length];
        for (int i = 1; i < matrix.length - 1; i++) {
            res[i - 1] = matrix[i];
        }
        return res;
    }
}
