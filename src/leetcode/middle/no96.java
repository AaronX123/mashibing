package leetcode.middle;

public class no96 {
    public int numTrees(int n) {
        // dp[i] 代表以第 i 个为根节点组成的 BST
        int[] dp = new int[n + 1];

        // 没有节点，只能形成空的 BST
        dp[0] = 1;
        // 只有一个节点，只能形成一颗 BST
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 左侧 j 个节点与右侧 i-j-1 个节点能组成的 BST
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
