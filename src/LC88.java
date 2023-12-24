import java.util.Arrays;

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[m] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}
