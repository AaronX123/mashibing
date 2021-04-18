package leetcode.middle;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class no102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return new ArrayList<>();
        deque.addFirst(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int curLayerCount = deque.size();
            while (curLayerCount > 0 ) {
                TreeNode curNode = deque.removeLast();
                cur.add(curNode.val);
                if (curNode.left != null) {
                    deque.addFirst(curNode.left);
                }
                if (curNode.right != null) {
                    deque.addFirst(curNode.right);
                }
                curLayerCount--;
            }
            res.add(cur);
        }
        return res;
    }
}
