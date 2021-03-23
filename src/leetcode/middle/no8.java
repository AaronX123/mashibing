package leetcode.middle;

public class no8 {
    public int myAtoi(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        int numBit = 0, other = 0;
        boolean negative = false;

        for (int i = 0; i < chars.length; i++) {
            // 说明不是0 到 9
            if ((((chars[i] - 48) > 9) || ((chars[i] - 48) < 0))) {
                if (other != 0 || numBit != 0) {
                    break;
                }
                if (chars[i] == '-' || chars[i] == '+') {
                    other++;
                    negative = chars[i] == '-';
                    continue;
                }
                // 说明是首次进入
                if (numBit == 0 && i != 0) {
                    return 0;
                }
                break;
            }
            res[numBit++] = chars[i];
        }
        if (numBit == 0) {
            return 0;
        }
        long n = 0;
        try {
            n = Long.parseLong(new String(res).trim());
        } catch (Exception e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (n > Integer.MAX_VALUE && !negative) return Integer.MAX_VALUE;
        else if (n > Integer.MAX_VALUE && negative) return Integer.MIN_VALUE;
        return negative ? -(int) n : (int) n;
    }

    public static void main(String[] args) {
        System.out.println("1".toCharArray()[0] - 48);
    }
}
