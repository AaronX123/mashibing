package leetcode.middle;

import leetcode.TreeNode;

public class no105 {
    // 先序遍历的第一个元素是整个树的根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree0(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree0(int[] preorder, int preStart, int preStartEnd, int[] order, int orderStart, int orderEnd) {
        if (preStart == preStartEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStartEnd - preStart == 1) {
            return root;
        }
        // 在中序遍历中找到root
        int rootVal = preorder[preStart];
        int rootIdxInOrder = -1;
        for (int i = orderStart; i < orderEnd; i++) {
            if (order[i] == rootVal) {
                rootIdxInOrder = i;
                break;
            }
        }
        if (rootIdxInOrder == -1) {
            throw new IllegalArgumentException("序列不属于相同的树");
        }
        int leftSubTreeLength = rootIdxInOrder - orderStart;
        root.left = buildTree0(preorder, preStart + 1, preStart + 1 + leftSubTreeLength, order, orderStart, orderStart + leftSubTreeLength);
        root.right = buildTree0(preorder, preStart + 1 + leftSubTreeLength, preStartEnd, order, rootIdxInOrder + 1, orderEnd);
        return root;
    }
}
