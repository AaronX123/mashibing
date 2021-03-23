package leetcode.easy;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class no66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        boolean carry = digits[digits.length - 1] + 1 >= 10;
        if (carry) {
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0 && carry; i--) {
                // 如果进位后还能进位
                if (carry && digits[i] == 9) {
                    digits[i] = 0;
                } else if (carry){
                    digits[i]++;
                    carry = false;
                }
            }
            // 处理超出数组长度的情况，直接返回一个[1,0,0,...,0]，这样的数组，因为必定是从最低位开始进位的。
            if (carry) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr;
            }
        } else {
            digits[digits.length - 1]++;
        }
        return digits;
    }

    public static void main(String[] args) {
        new no66().plusOne(new int[]{9,9,9});
    }
}
