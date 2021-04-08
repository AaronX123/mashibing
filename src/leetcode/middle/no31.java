package leetcode.middle;

public class no31 {
    // 从右向左找到第一个不是降序的字母，这样右边全是降序，只需要来回交换就是升序了，如果没找到这样的点，说明已经是最大字典序了，只需要来回交换即可
    public void nextPermutation(int[] nums) {
        int first = nums.length - 2;
        for (; first >= 0; first--) {
            if (nums[first] < nums[first + 1]) {
                break;
            }
        }
        // 说明是降序排列，应该转成升序
        if (first == -1) {
            asc(nums, 0);
            return;
        }
        // 再从右边找到第一个比first大的数
        int second = nums.length - 1;
        for (; second > first; second--) {
            if (nums[second] > nums[first]) {
                break;
            }
        }

        // 两数交换
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

        asc(nums, first + 1);
    }

    private void asc(int[] nums, int start) {
        // 对右边进行升序
        for (int i = start, j = nums.length -1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
