package leetcode.easy;

import leetcode.TreeNode;

public class no543 {
    // 统计左子树高度 + 右子树高度
    public int diameterOfBinaryTree(TreeNode root) {
        return heightOfTree(root.left, 0) + heightOfTree(root.right, 0);
    }

    private int heightOfTree(TreeNode node, int height) {
        if (node == null) return 0;
        int ld = heightOfTree(node.left, height);
        int rd = heightOfTree(node.right, height);
        return Math.max(ld, rd) + 1;
    }
}
