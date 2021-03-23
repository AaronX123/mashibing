package leetcode.easy;

public class no53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum, 0);
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new no53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
