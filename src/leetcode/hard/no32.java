package leetcode.hard;

import java.util.Stack;

public class no32 {
    // 暴力解法，第一重循环用于枚举起始位置，第二重循环用于枚举起始位置+j这一段是否为有效括号，如果是，尝试更新max O(N³), LeetCode中会超时
    private int max = 0;
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - max; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isCorrect(chars, i, j + 1)) {
                    int len = j + 1 - i;
                    if (len > max) max = len;
                }
                if (isRightParenthesisMore(chars, i, j + 1)) {
                    break;
                }
            }
        }
        return max;
    }

    private boolean isCorrect(char[] chars, int start, int end) {
        int leftParenthesisCount = 0;
        for (int i = start; i < chars.length && i < end; i++) {
            if (chars[i] == '(') leftParenthesisCount++;
            else if (leftParenthesisCount == 0) {
                return false;
            } else {
                leftParenthesisCount--;
            }
        }
        return leftParenthesisCount == 0;
    }

    private boolean isRightParenthesisMore(char[] chars, int start, int end) {
        int rightParenthesisCount = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == '(') rightParenthesisCount--;
            else if (rightParenthesisCount == 0) {
                return true;
            } else {
                rightParenthesisCount++;
            }
        }
        return rightParenthesisCount > 0;
    }

    public static void main(String[] args) {
        System.out.println(new no32().longestValidParentheses(")()())"));
    }


    // 用栈来保存匹配的括号下标。栈底放已经合法的括号序列最右边的那个不匹配的右括号下标，其余位置放左括号下标。
    public int longestValidParenthesesWithStack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 此时栈为空，说明这个右括号，没有左括号和它匹配，那么就把这个右括号的位置放进去
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
