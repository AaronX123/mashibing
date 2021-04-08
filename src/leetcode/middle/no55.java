package leetcode.middle;

public class no55 {
    public boolean canJump(int[] nums) {
        return canJump0(nums, nums.length - 2, nums.length - 1);
    }

    private boolean canJump0(int[] nums, int start, int targetIdx) {
        // 说明不能再往前找了
        if (start == 0) {
            return nums[start] >= targetIdx;
        }
        for (int i = start; i > 0; i--) {
            // 说明这个位置能到达index位置, 那么再往前看，i前面的位置能否到达i
            if (nums[i] + i >= targetIdx) {
                return canJump0(nums, i - 1, i);
            }
        }
        return nums[0] >= targetIdx;
    }

    // 始终维护着一个最远能到达的距离
    public boolean canJump2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 说明此时不可到达i位置
            if (max < i) return false;
            if (nums[i] + i > max) {
                max = nums[i] + i;
            }
        }
        return max >= (nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new no55().canJump(new int[]{2, 0, 0}));
    }
}
