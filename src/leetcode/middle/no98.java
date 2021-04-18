package leetcode.middle;

import leetcode.TreeNode;

public class no98 {
    long pre = Long.MIN_VALUE;
    // 二叉搜索树的中序遍历一定是有序的
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean lres = isValidBST(root.left);
        if (root.val <= pre) return false;
        pre = root.val;
        boolean rres = isValidBST(root.right);
        return lres && rres;
    }
}
