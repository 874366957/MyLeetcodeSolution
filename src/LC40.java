import java.util.*;

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            List<Integer> child = new ArrayList<>();
            boolean[] used = new boolean[candidates.length];
            used[i] = true;
            child.add(candidates[i]);
            dfs(target - candidates[i], candidates, res, child, used);
        }

        return new ArrayList<>(res);
    }

    void dfs(int target, int[] candidates, Set<List<Integer>> res, List<Integer> child, boolean[] used) {
        if (target == 0) {
            child.sort((a, b) -> a - b);
            res.add(child);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (used[i]) {
                continue;
            }
            List<Integer> next = new ArrayList<>(child);
            next.add(candidates[i]);
            boolean[] nextUsed = Arrays.copyOf(used, used.length);
            nextUsed[i] = true;
            dfs(target - candidates[i], candidates, res, next, nextUsed);
        }
    }
}
