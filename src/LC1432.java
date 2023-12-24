public class LC1432 {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                s = s.replaceAll(String.valueOf(s.charAt(i)), "9");
                break;
            }
        }
        String smaller = String.valueOf(num);
        for (int i = 0; i < smaller.length(); i++) {
            if (i == 0) {
                if (smaller.charAt(0) != '1') {
                    smaller = smaller.replaceAll(String.valueOf(smaller.charAt(0)), "1");
                    break;
                }
            } else {
                if (smaller.charAt(i) != '0') {
                    if (smaller.charAt(0) == '1' && smaller.charAt(i) == '1') {
                        continue;
                    }
                    smaller = smaller.replaceAll(String.valueOf(smaller.charAt(i)), "0");
                    break;
                }
            }
        }
        return Integer.parseInt(s) - Integer.parseInt(smaller);
    }
}
