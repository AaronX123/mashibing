package leetcode.easy;

import leetcode.TreeNode;

public class no226 {
    // 递归处理左边和右边
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
