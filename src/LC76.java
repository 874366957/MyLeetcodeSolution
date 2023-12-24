import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String res = "";
        HashMap<Character, Integer> target = count(t);
        boolean isExist = false;
        int lcurr = 0, rcurr = t.length() - 1;
        while (rcurr < s.length()) {
            String substring = s.substring(lcurr, rcurr + 1);
            HashMap<Character, Integer> cal = count(substring);
            if (isContains(cal,target)) {
                if (!isExist) {
                    res = substring;
                    isExist = true;
                } else {
                    res = res.length() > substring.length() ? substring : res;
                }
                lcurr++;
            } else {
                rcurr++;
            }
        }
        return res;
    }

    HashMap<Character, Integer> count(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer cnt = hashMap.getOrDefault(str.charAt(i), 0);
            cnt++;
            hashMap.put(str.charAt(i), cnt);
        }
        return hashMap;
    }

    boolean isContains(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (entry.getValue()>(source.getOrDefault(entry.getKey(),0))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
