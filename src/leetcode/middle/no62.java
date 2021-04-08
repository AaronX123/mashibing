package leetcode.middle;

import java.util.Arrays;

public class no62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 边界的走法只有1种
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);

        // 第 i , j位置的走法 = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
