package leetcode.easy;

public class no26 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length; ++i) {
            // 找到后面第一个不同的位置
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                break;
            }
            // 将第一个不同的位置元素放到i后面，然后i变成第一不同位置后
            if (count < nums.length && j < nums.length) {
                nums[count] = nums[j];
                i = j - 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new no26().removeDuplicates(new int[] {1,1,1,2,2,2,2,2,3,3,3,4}));
    }
}
