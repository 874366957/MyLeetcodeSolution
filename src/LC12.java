public class LC12 {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        StringBuffer numStr = new StringBuffer(String.valueOf(num));
        numStr.reverse();
        for (int i = 0; i < numStr.length(); i++) {
            StringBuffer bitStr = new StringBuffer();
            int bit = numStr.charAt(i) - '0';
            if (i == 0) {
                if (bit == 4) {
                    bitStr.append("IV");
                } else if (bit == 9) {
                    bitStr.append("XI");
                } else if (bit < 4) {
                    for (int j = 0; j < bit; j++) {
                        bitStr.append("I");
                    }
                } else {
                    bitStr.append("V");
                    for (int j = 0; j < bit - 5; j++) {
                        bitStr.append("I");
                    }
                }
            }
            if (i == 1) {
                if (bit == 4) {
                    bitStr.append("XL");
                } else if (bit == 9) {
                    bitStr.append("XC");
                } else if (bit < 4) {
                    for (int j = 0; j < bit; j++) {
                        bitStr.append("X");
                    }
                } else {
                    bitStr.append("L");
                    for (int j = 0; j < bit - 5; j++) {
                        bitStr.append("X");
                    }
                }
            }
            if (i == 2) {
                if (bit == 4) {
                    bitStr.append("CD");
                } else if (bit == 9) {
                    bitStr.append("CM");
                } else if (bit < 4) {
                    for (int j = 0; j < bit; j++) {
                        bitStr.append("C");
                    }
                } else {
                    bitStr.append("D");
                    for (int j = 0; j < bit - 5; j++) {
                        bitStr.append("C");
                    }
                }
            }
            if (i == 3) {
                for (int j = 0; j < bit; j++) {
                    bitStr.append("M");
                }
            }
            res = bitStr.append(res);
        }
        return new String(res);
    }
}
