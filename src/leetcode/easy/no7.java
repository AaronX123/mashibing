package leetcode.easy;

public class no7 {
    public int reverse(int x) {
        String str = x + "";
        char[] chars = str.toCharArray();
        char[] revert = new char[chars.length];
        if (chars[0] == '-') {
            for (int i = 1; i < chars.length; i++) {
                revert[chars.length - i] = chars[i];
            }
            revert[0] = '-';
        }else {
            for (int i = 0; i < chars.length; i++) {
                revert[chars.length - i - 1] = chars[i];
            }
        }
        int res;
        try {
            res= Integer.parseInt(new String(revert));
        } catch (Exception e) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new no7().reverse(1534236469));
    }
}
