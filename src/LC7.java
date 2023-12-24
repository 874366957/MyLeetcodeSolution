public class LC7 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        if (x >= 0) {
            long l = Long.parseLong(new String(sb.reverse()));
            if (l > Integer.MAX_VALUE) {
                return 0;
            }
            return Integer.parseInt(new String(sb));
        } else {
            sb.deleteCharAt(0);
            long l = Long.parseLong(new String(sb.reverse()));
            if (l > Integer.MAX_VALUE) {
                return 0;
            }
            return -Integer.parseInt(new String(sb));
        }
    }
}
