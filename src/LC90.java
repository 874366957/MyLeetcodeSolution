import java.util.*;

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                queue.add(nums[j]);
            }
            while (queue.size() - i >= 0) {
                Integer poll = queue.pollFirst();
                List<Integer> list = new ArrayList<>();
                list.add(poll);
                dfs(res, list, new LinkedList<>(queue), i - 1);
            }
        }
        res.add(new ArrayList<>());
        return new ArrayList(res);
    }

    void dfs(Set<List<Integer>> res, List<Integer> list, LinkedList<Integer> queue, int rest) {
        if (rest == 0) {
            res.add(list);
            return;
        }
        if (rest == queue.size()) {
            list.addAll(queue);
            res.add(list);
            return;
        }
        while (queue.size() - rest >= 0) {
            Integer poll = queue.pollFirst();
            List<Integer> next = new ArrayList<>(list);
            next.add(poll);
            dfs(res, next, new LinkedList<>(queue), rest - 1);
        }
    }
}
