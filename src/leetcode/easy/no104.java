package leetcode.easy;


import leetcode.TreeNode;

public class no104 {
    public static int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return max;
        dfs(root, max);
        return max;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) return;
        depth++;
        if (node.left == null && node.right == null) {
            max = Math.max(max, depth);
            return;
        }
        dfs(node.left, depth);
        dfs(node.right, depth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new no104().maxDepth(root));
    }
}
