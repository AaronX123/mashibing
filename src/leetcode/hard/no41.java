package leetcode.hard;

public class no41 {
    public int trap(int[] height) {
        int res = 0;
        if (height.length < 3) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        // 计算每个位置他左边的最大值是多少
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[rightMax.length -1] = height[height.length - 1];
        for (int i = height.length - 2; i > -1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        //
        for (int i = 0; i < leftMax.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    // 当向右遍历时，必须有个机制，确保右边一定存在比左边最高的柱子相同或者更高的，只要右边更高，那么影响该位置水量的因素就是左边最高柱子高度。
    public int trapDoublePoint(int[] height) {
        if (height.length < 3) return 0;
        int res = 0;
        int left = 0, right = height.length -1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new no41().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
