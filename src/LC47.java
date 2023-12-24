import java.util.*;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean[] next = new boolean[nums.length];
            next[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(res, list, nums, next);
        }
        return new ArrayList<>(res);
    }

    void dfs(Set<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        boolean addflag = true;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            addflag = false;
            boolean[] next = Arrays.copyOf(visited, visited.length);
            next[i] = true;
            List<Integer> nextList = new ArrayList<>(list);
            nextList.add(nums[i]);
            dfs(res, nextList, nums, next);
        }
        if (addflag) {
            res.add(list);
        }
    }
}
