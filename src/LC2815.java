import org.junit.Test;

import java.util.*;

public class LC2815 {
    @Test
    public void test() {
        System.out.println(maxSum(new int[]{8, 75, 28, 35, 21, 13, 21}));
    }

    public int maxSum(int[] nums) {
        int res = -1;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            for (int j = 0; j < s.length(); j++) {
                Integer cache = hash.getOrDefault(i, 0);
                if (s.charAt(j) - '0' > cache) {
                    hash.put(i, s.charAt(j) - '0');
                }
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hash.entrySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (Objects.equals(list.get(i).getValue(), list.get(j).getValue())) {
                    res = Math.max(res, nums[list.get(i).getKey()] + nums[list.get(j).getKey()]);
                }
            }
        }
        return res;
    }
}
