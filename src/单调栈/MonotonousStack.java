package 单调栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MonotonousStack {
    public static int[] monotonousStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 找到第一个比i位置元素小的地方，同时，栈顶元素一定不会被作为答案输出，所以把栈顶剔除
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // 说明栈里都比i元素大，所以应该为-1
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        str = bufferedReader.readLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        String res = Arrays.toString(monotonousStack(arr));
        res = res.replace(",", "");
        System.out.println(res.substring(1,res.length() - 1));
    }
}
