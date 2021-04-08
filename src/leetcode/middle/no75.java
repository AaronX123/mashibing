package leetcode.middle;

public class no75 {
    // 直接扫一遍，计算红色，蓝色，白色的个数，最后重建即可
    public void sortColors(int[] nums) {
        int redCnt = 0;
        int blueCnt = 0;
        int writeCnt = 0;
        for (int num : nums) {
            if (num == 0) redCnt++;
            else if (num == 1) writeCnt++;
            else if (num == 2) blueCnt++;
        }
        // rebuild
        for (int i = 0; i < redCnt; i++) {
            nums[i] = 0;
        }
        for (int i = redCnt; i < redCnt + writeCnt; i++) {
            nums[i] = 1;
        }
        for (int i = redCnt + writeCnt; i < redCnt + writeCnt + blueCnt; i++) {
            nums[i] = 2;
        }
    }

    // p0，p1，遇到0则和p0交换，然后p0,p1均向后移动一位，这样能保证1始终在0后面，同时如果p1 > p0，此时p0指向的一定是1，所以和0交换后，1就到第i的位置，需要和
    // p1交换
    public void sortColors2(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = temp;
            } else if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                if (p0 < p1) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p0++;
                p1++;
            }
        }
    }

    public static void main(String[] args) {
        new no75().sortColors(new int[]{2,0,2,1,1,0});
    }
}
