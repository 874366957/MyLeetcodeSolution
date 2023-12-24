import org.junit.Test;

import java.util.*;

public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int tar = 1;
        boolean found = false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort((a, b) -> a - b);
        int cur = 0;
        while (cur < list.size()) {
            Integer var = list.get(cur);
            if (var > 0) {
                found = true;
                if (var != tar) {
                    return tar;
                }
                tar++;
            }
            cur++;
        }
        return !found ? 1 : tar;
    }

    @Test
    public void exec() {
        firstMissingPositive(new int[]{1, 2, 0});
    }
}
