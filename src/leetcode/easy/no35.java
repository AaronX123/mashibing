package leetcode.easy;

public class no35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target > nums[nums.length - 1]) return nums.length;
        int idx = find(nums, target - 0.5);
        return idx;
    }

    private int find(int[] nums, double target) {
        int l, r;
        l = 0;
        r = nums.length;
        int mid = 0;
        while (l <= r) {
            mid = l + r >> 1;
            if (mid < nums.length && nums[mid] > target) {
                r = mid - 1;
            } else if (mid < nums.length && nums[mid] == target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new no35().searchInsert(new int[]{1,1,1,1,3,4,5,6},6));
    }
}
