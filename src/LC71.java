import org.junit.Test;

import java.util.LinkedList;
import java.util.StringJoiner;

public class LC71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(".") || split[i].isEmpty()) {
                continue;
            } else if (split[i].equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offerLast(split[i]);
            }
        }
        StringJoiner sj = new StringJoiner("/");
        for (int i = 0; i < queue.size(); i++) {
            sj.add(queue.get(i));
        }
        return "/" + sj.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/../"));
    }
}
