package leetcode.middle;

public class no11 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int volume = (right - left) * Math.min(height[left], height[right]);
            if (volume > max) max = volume;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
