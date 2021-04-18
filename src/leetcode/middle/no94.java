package leetcode.middle;

import leetcode.TreeNode;

import java.util.*;

public class no94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversalUseQueue(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null) {
            // 把左边走完
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return r;
    }

    public List<Integer> inorder2(TreeNode root) {
        ArrayList list = new ArrayList();
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if(o==null) continue;
            if (o instanceof TreeNode){
                stack.push(((TreeNode) o).right);
                stack.push(((TreeNode) o).val);
                stack.push(((TreeNode) o).left);
            }else{
                list.add(o);
            }
        }

        return list;
    }
}
