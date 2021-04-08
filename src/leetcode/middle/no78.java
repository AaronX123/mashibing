package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets0(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void subsets0(int[] nums, int cnt, List<Integer> list, List<List<Integer>> res) {
        if (cnt == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 取这个数
        list.add(nums[cnt]);
        subsets0(nums, cnt + 1, list, res);
        // 不取这个数
        list.remove(list.size() - 1);
        subsets0(nums, cnt + 1, list, res);
    }
}
