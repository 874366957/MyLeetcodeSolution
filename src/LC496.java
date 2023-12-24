import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> table = new TreeMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peekFirst()]) {
                Integer pop = stack.pop();
                table.put(nums2[pop], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = table.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
