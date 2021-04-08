package leetcode.middle;

public class no34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        int targetIdx = binarySearch(nums, target);
        if (nums[target] != target) return new int[]{-1, -1};
        // 向2边延伸
        int i = targetIdx;
        int j = targetIdx;
        for (; i > -1; i--) {
            if (nums[i] != target) break;
        }
        res[0] = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] != target) break;
        }
        res[1] = j - 1;
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new no34().searchRange(new int[]{}, 0);
    }
}
