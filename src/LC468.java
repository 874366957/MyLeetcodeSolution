import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC468 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < res.size()) {
                break;
            }
            List<Integer> divide = new ArrayList<>();
            for (int i = j; i >= 0; i--) {
                if (nums[i] % nums[j] == 0) {
                    divide.add(nums[i]);
                }
            }
            if (divide.size() > res.size()) {
                res = divide;
            }
        }
        return res;
    }
}
