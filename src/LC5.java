import java.util.Objects;

public class LC5 {
    public int a = 100;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        StringBuffer now = new StringBuffer(s);
        String reverse = new String(now.reverse());
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                String child = s.substring(i, j + 1);
                if (reverse.contains(child) && res.length() < child.length()) {
                    StringBuffer tem = new StringBuffer(child);
                    if (child.equals(new String(tem.reverse()))) {
                        res = child;
                    }
                }
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LC5 lc5 = (LC5) o;
        return a == lc5.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
