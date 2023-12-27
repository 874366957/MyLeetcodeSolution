import java.util.*;

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, LinkedList<Integer>> relationCache = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            relationCache.put(i, new LinkedList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            relationCache.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        LinkedList<Integer> learningQueue = new LinkedList<>();
        List<Integer> learnedList = new ArrayList<>();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : relationCache.entrySet()) {
            if (entry.getValue().isEmpty()) {
                learningQueue.offer(entry.getKey());
            }
        }
        while (!learningQueue.isEmpty()) {
            Integer poll = learningQueue.poll();
            learnedList.add(poll);
            for (Map.Entry<Integer, LinkedList<Integer>> entry : relationCache.entrySet()) {
                if (entry.getValue().contains(poll)) {
                    entry.getValue().remove(Integer.valueOf(poll));
                    if (entry.getValue().isEmpty()) {
                        learningQueue.offer(entry.getKey());
                    }
                }
            }
        }
        if (learnedList.size() == numCourses) {
            return learnedList.stream().mapToInt(Integer::valueOf).toArray();
        }
        return new int[0];
    }
}
