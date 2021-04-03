package leetcode.hard;

public class no4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                temp[k++] = nums2[j++];
            } else {
                temp[k++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }
        int mid = temp.length >> 1;
        if (temp.length % 2 == 0) {
            double res = temp[mid - 1];
            res = (res + temp[mid]) / 2;
            return res;
        }
        return temp[mid];
    }

    public static void main(String[] args) {
        new no4().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
}
