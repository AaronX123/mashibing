package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、暴力解法是枚举n对括号的所有可能性，然后判断是否合法，合法放集合里
 * 2、回溯法，左括号个数为n，右括号个数为n，当左括号个数==右括号个数时，必须放左括号，不然一定会剩右括号，当左括号个数<右括号个数时，可以再放左括号也
 * 可以放右括号。
 */
public class no22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generate0("", n, n);
        return res;
    }

    private void generate0(String str, int leftParenthesis, int rightParenthesis) {
        // 此时说明枚举完了
        if (leftParenthesis == 0 && rightParenthesis == 0) {
            res.add(str);
            return;
        }
        // 必须放左括号
        if (leftParenthesis == rightParenthesis) {
            generate0(str + "(", leftParenthesis - 1, rightParenthesis);
        } else {
            // 可以放左括号也可以放右括号
            if (leftParenthesis > 0) {
                generate0(str + "(", leftParenthesis - 1, rightParenthesis);
            }
            generate0(str + ")", leftParenthesis, rightParenthesis - 1);
        }
    }
}
