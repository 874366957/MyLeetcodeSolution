import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() - k >= 0) {
            Integer poll = queue.pollFirst();
            List<Integer> list = new ArrayList<>();
            list.add(poll);
            dfs(res, list, new LinkedList<>(queue), k - 1);
        }
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> list, LinkedList<Integer> queue, int rest) {
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

    @Test
    public void test() {
        combine(4, 2);
    }
}
