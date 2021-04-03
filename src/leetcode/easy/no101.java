package leetcode.easy;


import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class no101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    private static boolean isSymmetric2(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        new no101().isSymmetric(head);
    }
}
