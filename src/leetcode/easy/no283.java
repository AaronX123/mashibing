package leetcode.easy;

public class no283 {

    public void moveZeroes(int[] nums) {
        // 移动剩下的非零数字
        int noZeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noZeroIdx++] = nums[i];
            }
        }

        for (int i = noZeroIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        // 双指针，左边指向的是满足要求的序列最后一个位置，右边是未处理的序列起始位置
        int l = 0, r = 0;
        while (r < nums.length) {
            // 如果是0，就跳过，如果不是0，就去和左边的0交换位置
            if (nums[r] != 0) {
                int temp = nums[r];
                nums[r] = 0;
                nums[l++] = temp;
            }
            r++;
        }
    }
}
