import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC1980 {
    public String findDifferentBinaryString(String[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int parseInt = Integer.parseInt(nums[i], 2);
            list.add(parseInt);
        }
        String value = null;
        for (int i = (int) Math.pow(2, nums[0].length()) - 1; i >= 0; i--) {
            if (!list.contains(i)) {
                value = Integer.toBinaryString(i);
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (value.length() < nums[0].length()) {
            for (int i = 0; i < nums[0].length() - value.length(); i++) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(value);
        return new String(stringBuilder);
    }
}
