package leetcode.easy;

public class no9 {
    public boolean isPalindrome(int x) {
        String xa = x + "";
        StringBuilder stringBuilder = new StringBuilder(xa);
        return stringBuilder.reverse().toString().equals(xa);
    }

    public boolean isPalindrome2(int x) {
        String xa = x + "";
        char[] chars = xa.toCharArray();
        int i,j;
        for (i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
            if (chars[i] == chars[j] && i < j) {
                continue;
            }
            if (i >= j) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new no9().isPalindrome2(12121));
    }
}
