package leetcode.middle;

import leetcode.TreeNode;

public class no114 {
    // 当前节点的右孩子应该接到左孩子的最右孩子上
    public void flatten(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        TreeNode right = node.right;

        inorder(node.left);
        inorder(node.right);

        if (node.left != null) {
            // 将左孩子置为next
            node.right = node.left;
            node.left = null;
            // 找到左孩子链表的最后一个节点，然后把右孩子接上去
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r5 = new TreeNode(5);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r6 = new TreeNode(6);
        root.left = r2;
        root.right = r5;
        r2.left = r3;
        r2.right = r4;
        r5.right = r6;
        new no114().flatten(root);
        System.out.println(root);
    }
}
