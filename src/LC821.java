import java.util.Arrays;
import java.util.LinkedList;

public class LC821 {
    public int[] shortestToChar(String s, char c) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        int[] pre = new int[s.length()], suf = new int[s.length()];
        Arrays.fill(pre, s.length());
        Arrays.fill(suf, s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                while (!stack1.isEmpty()) {
                    int pop = stack1.pop();
                    pre[pop] = i - pop;
                }
                pre[i] = 0;
                continue;
            }
            stack1.push(i);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                while (!stack2.isEmpty()) {
                    int pop = stack2.pop();
                    suf[pop] = pop - i;
                }
                suf[i] = 0;
                continue;
            }
            stack2.push(i);
        }
        int[] matrix = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            matrix[i] = Math.min(pre[i], suf[i]);
        }
        return matrix;
    }

}
