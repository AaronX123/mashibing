package leetcode.easy;
import java.util.Stack;

public class no20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                if (isPair(stack.peek(), chars[i])) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char a, char b) {
        return a == '[' && b == ']' ||
            a == '{' && b == '}' ||
            a == '(' && b == ')';
    }


    public static void main(String[] args) {
        System.out.println(new no20().isValid("{[]}"));
    }
}
