import java.util.*;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            List<Integer> child = new ArrayList<>();
            child.add(candidates[i]);
            dfs(target - candidates[i], candidates, res, child);
        }

        return new ArrayList<>(res);
    }

    void dfs(int target, int[] candidates, Set<List<Integer>> res, List<Integer> child) {
        if (target == 0) {
            child.sort((a, b) -> a - b);
            res.add(child);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            List<Integer> next = new ArrayList<>(child);
            next.add(candidates[i]);
            dfs(target - candidates[i], candidates, res, next);
        }
    }
}
