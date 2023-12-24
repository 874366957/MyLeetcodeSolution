import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        List<StringBuffer> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuffer());
        }
        search(s, res, 0, 0, true);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < res.size(); i++) {
            sbf.append(res.get(i));
        }
        return sbf.toString();
    }

    static void search(String s, List<StringBuffer> res, int height, int i, boolean cur) {
        if (i == s.length()) {
            return;
        }
        if (height == 0) {
            cur = true;
        } else if (height == res.size() - 1) {
            cur = false;
        }
        res.get(height).append(s.charAt(i));
        int nextheight = cur ? height + 1 : height - 1;
        int nextch = i + 1;
        search(s, res, nextheight, nextch, cur);
    }
}
