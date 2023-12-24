import java.util.ArrayList;
import java.util.LinkedList;

public class LC80 {
    public int removeDuplicates(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Integer tar = queue.pollFirst();
        arr.add(tar);
        int count = 1;
        while (!queue.isEmpty()) {
            Integer first = queue.pollFirst();
            if (first.equals(tar)) {
                if (count < 2) {
                    count++;
                    arr.add(first);
                }
            } else {
                count = 1;
                tar = first;
                arr.add(first);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
        return arr.size();
    }
}
