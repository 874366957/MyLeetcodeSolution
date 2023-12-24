import java.util.*;

public class LC162 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> cnt = new HashMap<>();
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                Integer count = cnt.getOrDefault(str.charAt(j), 0);
                count++;
                cnt.put(str.charAt(j), count);
            }
            List<String> list = map.getOrDefault(cnt, new ArrayList<>());
            list.add(str);
            map.put(cnt, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
