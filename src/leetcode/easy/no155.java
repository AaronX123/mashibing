package leetcode.easy;

import java.util.Stack;

/**
 * 最小栈
 */
public class no155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public no155() {

    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (minStack.peek() > val) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
