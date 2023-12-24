import java.util.HashMap;
import java.util.Map;

public class LC2048 {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1000));
    }

    public static int nextBeautifulNumber(int n) {
        for (int i = n + 1; i < 1000000; i++) {
            HashMap<Character, Integer> now = createMap(i);
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : now.entrySet()) {
                int value = entry.getValue();
                int key = entry.getKey() - '0';
                if (!(value == key)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    private static HashMap<Character, Integer> createMap(int i) {
        String v = String.valueOf(i);
        HashMap<Character, Integer> now = new HashMap<>();
        for (int j = 0; j < v.length(); j++) {
            Integer res = now.getOrDefault(v.charAt(j), 0);
            now.put(v.charAt(j), ++res);
        }
        return now;
    }
}
