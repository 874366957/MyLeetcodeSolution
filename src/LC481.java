public class LC481 {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        StringBuffer sb = new StringBuffer("122");
        int curr = 2;
        boolean market = false;
        while (sb.length() < n) {
            char c = sb.charAt(curr);
            if (market) {
                if (c == '1') {
                    sb.append("2");
                } else {
                    sb.append("22");
                }
            } else {
                if (c == '1') {
                    sb.append("1");
                } else {
                    sb.append("11");
                }
            }
            curr++;
            market = !market;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
