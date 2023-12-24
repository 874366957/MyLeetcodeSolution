import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean[] next = new boolean[nums.length];
            next[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(res, list, nums, next);
        }
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
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
