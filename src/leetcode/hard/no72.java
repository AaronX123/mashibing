package leetcode.hard;

public class no72 {
    // 思路：word1 可以采用插入和word2末尾相同的字符达到消掉word2最后一个字，也可以通过插入和word2末尾相同字符的方式消掉，也可以通过直接替换来消掉.
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 初始化，对于空字符串来说，匹配的次数就是删除的次数
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int delOp = dp[i - 1][j] + 1;
                int insertOp = dp[i][j - 1] + 1;
                int replaceOp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replaceOp ++;
                }
                dp[i][j] = Math.min(delOp, Math.min(insertOp, replaceOp));
            }
        }
        return dp[l1][l2];
    }
}
