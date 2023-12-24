import java.util.LinkedList;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] matrix = new int[temperatures.length];
        stack.push(temperatures.length - 1);
        int curr = temperatures.length - 2;
        while (curr >= 0) {
            while (!stack.isEmpty() && temperatures[curr] >= temperatures[stack.peekFirst()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(curr);
                matrix[curr] = 0;
            } else {
                matrix[curr] = stack.peekFirst() - curr;
                stack.push(curr);
            }
            curr--;
        }
        return matrix;
    }
}
