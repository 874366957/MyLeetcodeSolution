import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    static Map<Character, char[]> map = new HashMap<>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        List<StringBuffer> res = new ArrayList<>();
        char[] chars = map.get(digits.charAt(0));
        for (int i = 0; i < chars.length; i++) {
            res.add(new StringBuffer().append(chars[i]));
        }
        dfs(res, 1, digits);
        for (StringBuffer stringBuffer : res) {
            list.add(new String(stringBuffer));
        }
        return list;
    }

    static void dfs(List<StringBuffer> res, int curr, String digits) {
        if (curr >= digits.length()) {
            return;
        }
        char[] chars = map.get(digits.charAt(curr));
        List<StringBuffer> now = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < chars.length; j++) {
                StringBuffer stringBuffer = new StringBuffer(res.get(i));
                stringBuffer.append(chars[j]);
                now.add(stringBuffer);
            }
        }
        res.clear();
        res.addAll(now);
        dfs(res, ++curr, digits);
    }
}
