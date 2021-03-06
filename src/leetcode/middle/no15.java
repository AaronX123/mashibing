package leetcode.middle;

import java.util.*;

public class no15 {
    // n²logn
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 跳过相同的元素，确保一定是唯一的解
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int bIdx = i + 1;
            int cIdx = nums.length - 1;
            int target = -nums[i];
            for (; bIdx < nums.length; bIdx++) {
                if (bIdx > i + 1 && nums[bIdx] == nums[bIdx - 1]) continue;
                while (bIdx < cIdx && nums[bIdx] + nums[cIdx] > target) {
                    cIdx--;
                }
                if (bIdx == cIdx) {
                    break;
                }
                if (nums[bIdx] + nums[cIdx] == target) {
                    List<Integer> seq = new ArrayList<>();
                    seq.add(nums[i]);
                    seq.add(nums[bIdx]);
                    seq.add(nums[cIdx]);
                    res.add(seq);
                }
            }
        }
        return res;
    }

    private boolean isDuplicate(List<List<Integer>> cur, List<Integer> list) {
        for (List<Integer> integerList : cur) {
            int same = 0;
            for (Integer integer : integerList) {
                if (list.contains(integer)) {
                    same++;
                }
            }
            if (same == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new no15().threeSum2(new int[]{-1,0,1,2,-1,-4});
    }

    /**
     * n² 首先排序，这样能避免 {a,b,c}, {c,b,a}的情况
     * 然后由于数组是有序的，所以为了避免出现{-3,1,2,2,2} 中 取到 {-3,1,第一个2},{-3,1,第二个2}这样的情况，对于相同的数字要跳过
     * 同时a + b + c = 0, b越向右移动，c就必须越小，因此c是--操作
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int c = nums.length - 1;
            // 处理b
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + i && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 如果a + b + c = 0
                if (nums[i] + nums[j] + nums[c] == 0) {
                    List<Integer> seq = new ArrayList<>();
                    seq.add(nums[i]);
                    seq.add(nums[j]);
                    seq.add(nums[c]);
                    res.add(seq);
                }
                // c 要在 b 的右边
                while (c > j && nums[j] + nums[c] >0 - nums[i]) {
                    c--;
                }

                // 如果b 和 c相遇了，说明没有
                if (j >= c) {
                    break;
                }
            }
        }
        return res;
    }
}
