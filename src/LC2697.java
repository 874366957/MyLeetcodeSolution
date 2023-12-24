import java.lang.reflect.Field;

public class LC2697 {
    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("abcd"));
    }

    public static String makeSmallestPalindrome(String s) {
        int rcurr = s.length() - 1;
        int lcurr = 0;
        StringBuffer stringBuffer = new StringBuffer(s);
        while (lcurr <= rcurr) {
            if (stringBuffer.charAt(lcurr) < stringBuffer.charAt(rcurr)) {
                stringBuffer.setCharAt(rcurr, stringBuffer.charAt(lcurr));
            } else if(stringBuffer.charAt(lcurr) > stringBuffer.charAt(rcurr)) {
                stringBuffer.setCharAt(lcurr, stringBuffer.charAt(rcurr));
            }
            lcurr++;
            rcurr--;
        }
        return s;
    }
}
