package leetcode.easy;

public class no28 {
    public int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("")) {
            return 0;
        }
        if (needle.equals("")) return 0;
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int start = 0;
        int i = 0;
        int j = 0;
        for (; i < hay.length; i++) {
            // 先找到匹配到的第一个元素
            if (hay[i] == nee[j]) {
                // 保存起点
                start = i;
                while (i < hay.length && j < nee.length) {
                    if (hay[i] == nee[j]) {
                        i++;
                        j++;
                    } else {
                        break;
                    }
                    if (j == nee.length) {
                        return start;
                    }
                }
                i = start + j - 1;
                j = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new no28().strStr("mississippi","issip"));
    }
}
