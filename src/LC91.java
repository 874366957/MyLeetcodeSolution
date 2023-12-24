import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC91 {

    @Test
    public void test() {
        int i = numDecodings("111111111111111111111111111111111111111111111");
        System.out.println(i);
    }

    public int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        Integer[] matrix = new Integer[s.length()];
        matrix[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        return dfs(s, 0, matrix);
    }

    int dfs(String s, int curr, Integer[] matrix) {
        if (matrix[curr] != null) {
            return matrix[curr];
        }
        if (s.charAt(curr) == '0') {
            matrix[curr] = 0;
            return 0;
        }
        if (curr == s.length() - 2) {
            if (Integer.parseInt(s.substring(curr)) > 26) {
                matrix[curr] = matrix[s.length() - 1];
            } else {
                matrix[curr] = matrix[s.length() - 1] + 1;
            }
            return matrix[curr];
        }
        if (Integer.parseInt(s.substring(curr, curr + 2)) > 26) {
            matrix[curr] = dfs(s, curr + 1, matrix);
            return matrix[curr];
        }
        matrix[curr] = dfs(s, curr + 1, matrix) + dfs(s, curr + 2, matrix);
        return matrix[curr];
    }

    char parse(String tochar) {
        int i = Integer.parseInt(tochar);
        return (char) ('A' + i - 1);
    }

    boolean check(String bit) {
        if (bit.isEmpty()) {
            return false;
        }
        if (bit.charAt(0) == '0') {
            return false;
        }
        int i = Integer.parseInt(bit);
        if (i > 26) {
            return false;
        }
        return true;
    }
}
