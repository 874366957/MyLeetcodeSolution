import java.util.Arrays;

public class LC81 {
    public boolean search(int[] nums, int target) {
        int lcurr = 0, rcurr = nums.length - 1;
        while (lcurr <= rcurr) {
            int mid = (lcurr + rcurr) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[lcurr] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[lcurr] <= target) {
                    rcurr = mid - 1;
                } else {  //否则，去后半部分找
                    lcurr = mid + 1;
                }
            } else if (nums[lcurr] == nums[mid]) {
                lcurr++;
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[rcurr] >= target) {
                    lcurr = mid + 1;
                } else {  //否则，去后半部分找
                    rcurr = mid - 1;

                }
            }
        }
        return false;
    }
}
