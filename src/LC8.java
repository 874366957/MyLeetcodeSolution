import java.math.BigDecimal;

public class LC8 {
    public int myAtoi(String s) {
        StringBuffer trim = new StringBuffer(s.trim());
        if(trim.length()==0){
            return 0;
        }
        int curr = 0;
        StringBuilder sb = new StringBuilder();
        boolean isNeg = false;
        boolean isDigitalFound = false;
        if(trim.charAt(0)=='-'||trim.charAt(0)=='+'){
            isNeg = trim.charAt(0)=='-'?true:false;
            trim.deleteCharAt(0);
        }
        while (curr < trim.length()) {
            char c = trim.charAt(curr);
            if (!isDigitalFound && c >= '0' && c <= '9') {
                isDigitalFound = true;
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
            curr++;
        }
        if (!isDigitalFound) {
            return 0;
        }
        BigDecimal l = new BigDecimal(new String(sb));
        if(isNeg) {
            return l.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0 ? Integer.MIN_VALUE : - Integer.parseInt(new String(sb));
        } else {
            return l.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0 ? Integer.MAX_VALUE : Integer.parseInt(new String(sb));
        }
    }
}
