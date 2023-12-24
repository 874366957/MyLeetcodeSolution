import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC60 {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        dfs(sb, list, k);
        return new String(sb);
    }

    void dfs(StringBuffer stringBuffer, List<Integer> list, int k) {
        if (list.size() <= 1) {
            stringBuffer.append(list.get(0));
            return;
        }
        int range = calRange(list.size() - 1);
        int i = (k - 1) / range;
        stringBuffer.append(list.get(i));
        list.remove(i);
        k = k - (i) * range;
        dfs(stringBuffer, list, k);
    }

    int calRange(int n) {
        int i = 1;
        while (n > 0) {
            i = i * n;
            n--;
        }
        return i;
    }

    @Test
    public void test() {
        System.out.println(getPermutation(3, 3));
    }
}
