import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

public class LC1423 {
    public static void main(String[] args) {
        int[] i = {96, 90, 41, 82, 39, 74, 64, 50, 30};
//        System.out.println(maxScore(i, 8));
        try {
            Class<?> lc1423 = Class.forName("LC1423");
            Method maxScore = lc1423.getMethod("maxScore", int[].class, int.class);
            Type genericReturnType = maxScore.getGenericReturnType();
            String typeName = genericReturnType.getTypeName();
            Class<?> aClass = Class.forName(typeName);
            int invoke = (int) maxScore.invoke(lc1423.newInstance(), i, 8);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public Integer maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            int now = 0;
            for (int j = 0; j < i; j++) {
                now = now + cardPoints[j];
            }
            for (int j = i + windowSize; j < n; j++) {
                now = now + cardPoints[j];
            }
            sum = Math.max(sum, now);
        }
        return sum;
    }

    static int dfs(int[] cardPoints, int k, int left, int right) {
        if (k == 0) {
            return 0;
        }
        if (left == right) {
            return cardPoints[left];
        }
        if (left > right) {
            return 0;
        }
        int lsum = cardPoints[left] + dfs(cardPoints, k - 1, left + 1, right);
        int rsum = cardPoints[right] + dfs(cardPoints, k - 1, left, right - 1);
        return Math.max(lsum, rsum);
    }

}
