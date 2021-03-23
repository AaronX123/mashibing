package leetcode.easy;

public class no14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[][] charsArr = new char[strs.length][];
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < charsArr.length; i++) {
            charsArr[i] = strs[i].toCharArray();
            if (minLength > strs[i].length()) minLength = strs[i].length();
        }
        char[] res = new char[minLength];
        int i = 0;
        for (i = 0; i < minLength; i++) {
            if (isCommonChar(i, charsArr)) {
                res[i] = charsArr[0][i];
            } else {
                break;
            }
        }
        return new String(res, 0, i);
    }

    private boolean isCommonChar(int curIndex, char[][] charsArr) {
        char cur = charsArr[0][curIndex];
        for (int i = 1; i < charsArr.length; i++) {
            if (cur != charsArr[i][curIndex]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[0];
        System.out.println(new no14().longestCommonPrefix(strs));
    }

}
