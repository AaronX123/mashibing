package rbtree;

import java.util.Objects;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-11-06
 */
public class RBTree<T> {
    private class TreeNode<T> {
        T val;
        boolean red;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        TreeNode(T val, TreeNode<T> parent) {
            this.val = val;
            this.red = true;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode<?> treeNode = (TreeNode<?>) o;
            return Objects.equals(val, treeNode.val);
        }

        @Override
        public int hashCode() {
            return val.hashCode();
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", red=" + red +
                    '}';
        }
    }

    private TreeNode<T> root;
    private int size;

    public RBTree() {}

    public void insert(T val) {
        TreeNode<T> x;
        if (root == null) {
            root = x = new TreeNode<>(val,null);
        } else {
            TreeNode<T> insertNode = find(val,root);
            x = insert0(insertNode,val);
        }
        reBalanceAfterInsert(x);
        size++;
    }

    private TreeNode<T> find(T target, TreeNode<T> cur) {
        if (cur == null) {
            return null;
        }
        int ch = cur.hashCode();
        int th = target.hashCode();
        TreeNode<T> next;
        if (ch <= th) {
            return (next = find(target,cur.right)) == null ? cur : next;
        } else {
            return (next = find(target,cur.left)) == null ? cur : next;
        }
    }

    private TreeNode<T> insert0(TreeNode<T> insertPoint, T val) {
        TreeNode<T> n = new TreeNode<>(val,insertPoint);
        if (insertPoint.hashCode() <= n.hashCode()) {
            insertPoint.right = n;
        } else {
            insertPoint.left = n;
        }
        return n;
    }

    private void reBalanceAfterInsert(TreeNode<T> x) {
        if (root == x) {
            x.red = false;
            return;
        }
        TreeNode<T> xp = x.parent;
        TreeNode<T> xpp = xp.parent;
        // 如果父节点是黑色或者祖父节点不存在直接结束调整
        if (!xp.red || xpp == null) {
            return;
        }
        TreeNode<T> uncle = xpp.left == xp ? xpp.right : xpp.left;
        // 如果叔叔节点存在且为红色，则xp和uncle变黑xpp变红，同时考虑对更大一层的影响
        if (uncle != null && uncle.red) {
            xp.red = false;
            uncle.red = false;
            xpp.red = true;
            reBalanceAfterInsert(xpp);
            return;
        }
        // 如果叔叔节点为黑色且xp == xpp.left，则xp绕x左旋，完成后考虑影响
        if (uncle != null) {
            handleBlackUncle(x,xp,xpp);
            reBalanceAfterInsert(xp);
            return;
        }

        if (inline(x,xp,xpp)) {
            handleInline(x,xp,xpp);
            return;
        }
        if (typeZ(x,xp,xpp)) {
            if (xpp.right == xp) {
                xpp.right = x;
                x.right = xp;
                xp.left = null;
            } else {
                xpp.left = x;
                x.left = xp;
                xp.right = null;
            }
            x.parent = xpp;
            xp.parent = x;
            reBalanceAfterInsert(xp);
        }

    }

    private boolean inline(TreeNode<T> x, TreeNode<T> xp, TreeNode<T> xpp) {
        return (xpp.left == xp && xp.left == x) || (xpp.right == xp && xp.right == x);
    }

    private boolean typeZ(TreeNode<T> x, TreeNode<T> xp, TreeNode<T> xpp) {
        return (xpp.left == xp && xp.right == x) || (xpp.right == xp && xp.left == x);
    }

    private void handleInline(TreeNode<T> x, TreeNode<T> xp, TreeNode<T> xpp) {
        if (xp.right == x) {
            if (xpp.parent != null) {
                handleXppp(xp,xpp);
            }
            xpp.parent = xp;
            if (xpp == root) {
                root = xp;
                root.parent = null;
            }
            xpp.right = xp.left;
            if (xp.left != null) {
                xp.left.parent = xpp;
            }
            xp.left = xpp;
        } else {
            if (xpp.parent != null) {
                handleXppp(xp,xpp);
            }
            xpp.parent = xp;
            if (xpp == root) {
                root = xp;
                root.parent = null;
            }
            xpp.left = xp.right;
            if (xp.right != null) {
                xp.right.parent = xpp;
            }
            xp.right = xpp;
        }
        xp.red = false;
        xpp.red = true;
    }

    private void handleXppp(TreeNode<T> xp, TreeNode<T> xpp) {
        if (xpp.parent.left == xpp) {
            xpp.parent.left = xp;
            xp.parent = xpp.parent;
        } else {
            xpp.parent.right = xp;
            xp.parent = xpp.parent;
        }
    }

    /**
     * 如果是typeZ类型，则xpp绕x旋转，如果是/类型，则xpp绕xp旋转。
     * @param x
     * @param xp
     * @param xpp
     */
    private void handleBlackUncle(TreeNode<T> x, TreeNode<T> xp, TreeNode<T> xpp) {
        if (typeZ(x,xp,xpp)) {
            if (xpp.left == xp) {
                xpp.left = x;
                xp.right = x.left;
                if (x.left != null) {
                    x.left.parent = xp;
                }
                x.left = xp;
            } else {
                xpp.right = x;
                xp.left = x.right;
                if (x.right != null) {
                    x.right.parent = xp;
                }
                x.right = xp;
            }
            x.parent = xpp;
            xp.parent = x;
        } else {
            if (xpp.left == xp) {
                xpp.left = xp.right;
                if (xp.right != null) {
                    xp.right.parent = xpp;
                }
                xp.right = xpp;
            } else {
                xpp.right = xp.left;
                if (xp.left != null) {
                    xp.left.parent = xpp;
                }
                xp.left = xpp;
            }
            if (root == xpp) {
                root = xp;
            }
            if (xpp.parent != null) {
                handleXppp(xp,xpp);
            }
            xpp.parent = xp;
            xpp.red = true;
            xp.red = false;
        }
    }

    public int size() {
        return size;
    }
}
