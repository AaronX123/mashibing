package leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class no3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        int currentLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                // 找到Set里重复元素在chars里的下标位置，比如dvdf，d是重复元素，应该找到第一个位置上的d的下标，也就是0。
                // 理由：应该把i重置到重复元素的下标的后一个位置上，但是由于循环会导致i额外加一，所以代码里不++
                for (int j = i - 1; j >= 0; j--) {
                    if (chars[j] == chars[i]) {
                        i = j;
                        break;
                    }
                }
                if (currentLength > max) {
                    max = currentLength;
                }
                currentLength = 0;
                set.clear();
            } else {
                set.add(chars[i]);
                currentLength++;
            }
        }
        return currentLength > max ? currentLength : max;
    }

    public static void main(String[] args) {
        new no3().lengthOfLongestSubstring("dvdf");
    }
}
