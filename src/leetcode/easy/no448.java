package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class no448 {
    // 第一眼做法： 开个n的数组，然后扫第一遍的时候讲数字存到对应的槽里，然后再扫一遍
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length + 1];
        // 因为题目给了范围是1-n，所以可以直接存
        for (int num : nums) {
            count[num]++;
        }
        // 再扫一遍
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) res.add(i);
        }
        return res;
    }

    // 思路二， 复用参数数组当hash表
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // 把出现的数字对应的下标上元素置为负数
        for (int num : nums) {
            int x = Math.abs(num) - 1;
            nums[x] = nums[x] < 0 ? nums[x] :-1 * nums[x];
        }
        // 再扫一次， 如果该位置上的数字大于0，说明这个位置上的数字没出现过
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
