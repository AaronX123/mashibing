package leetcode.middle;

public class no152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max, tempMin = min;
            max = Math.max(tempMax * nums[i], Math.max(nums[i], tempMin * nums[i]));
            min = Math.min(tempMax * nums[i], Math.min(nums[i], tempMin * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
