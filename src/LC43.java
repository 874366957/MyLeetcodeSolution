public class LC43 {
    public String multiply(String num1, String num2) {
        int num1bit = 1;
        int sum = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Int = num1.charAt(i) - '0';
            int num2MultiSum = 0;
            if (num1Int != 0) {
                int num2bit = 1;
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int num2Int = num2.charAt(j) - '0';
                    num2MultiSum += num1Int * num2Int * num2bit;
                    num2bit = num2bit * 10;
                }
            }
            sum += num2MultiSum * num1bit;
            num1bit = num1bit * 10;
        }
        return String.valueOf(sum);
    }
}
