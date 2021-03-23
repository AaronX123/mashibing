package leetcode.easy;

public class no27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        // 如果不同的话，就直接把这个不同的位置放到要去掉的地方
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        System.out.println(new no27().removeElement(new int[]{3,3}, 3));
    }
}
