package leetcode.easy;

public class no169 {
    public int majorityElement(int[] nums) {
        // 思路，维护一个数字，以及这个数字出现的次数，如果这个数字为众数，那么一定它的“敌人”比它少，那么一换一，最终剩下的就是众数了
        int target = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count++;
            } else {
                if (target == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return target;
    }
}
