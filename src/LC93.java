import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) {
            return res;
        }
        for (int i = 1; i <= 3; i++) {
            String substring = s.substring(0, i);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(substring) > 255) {
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(substring).append(".");
            dfs(res, s.substring(i), stringBuffer, 3);
        }
        return res;
    }

    void dfs(List<String> res, String source, StringBuffer stringBuffer, int left) {
        if (source.length() < left) {
            return;
        }
        if (left == 1) {
            if (source.length() > 1 && source.charAt(0) == '0') {
                return;
            }
            if (Integer.parseInt(source) > 255) {
                return;
            }
            stringBuffer.append(source);
            res.add(new String(stringBuffer));
            return;
        }
        int k = Math.min(source.length(), 3);
        for (int i = 1; i <= k; i++) {
            String substring = source.substring(0, i);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(substring) > 255) {
                continue;
            }
            StringBuffer next = new StringBuffer(stringBuffer);
            next.append(substring).append(".");
            dfs(res, source.substring(i), next, left - 1);
        }
    }
}
