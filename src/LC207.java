import org.junit.Test;

import java.util.*;

public class LC207 {
    @Test
    public void test() {
        canFinish(2, new int[][]{{1, 0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, LinkedList<Integer>> cache = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            cache.put(i, new LinkedList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            cache.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> learnedList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> reilableCources = cache.get(i);
            if (reilableCources.isEmpty()) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            learnedList.add(poll);
            for (Map.Entry<Integer, LinkedList<Integer>> entry : cache.entrySet()) {
                if (entry.getValue().contains(poll)) {
                    entry.getValue().remove(Integer.valueOf(poll));
                    if (entry.getValue().size() == 0) {
                        queue.offer(entry.getKey());
                    }
                }
            }
        }
        return numCourses == learnedList.size();
    }
}
