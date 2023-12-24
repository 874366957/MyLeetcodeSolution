public class LC38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        String begin = "1";
        for (int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int lcur = 0, rcur = lcur;
            while (rcur < begin.length()) {
                while (begin.charAt(lcur) == begin.charAt(rcur)) {
                    rcur++;
                    if (rcur >= begin.length()) {
                        break;
                    }
                }
                sb.append(rcur - lcur);
                sb.append(begin.charAt(lcur));
                lcur = rcur;
            }
            begin = new String(sb);
        }
        return begin;
    }
}
