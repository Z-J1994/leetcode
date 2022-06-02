package medium;

import tree.TreeNode;
import utils.TreeUtil;

/**
 * @author zhangjun
 * @since 2022/6/2 13:09
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode x = root;
        root = new TreeNode(-1, root, null);
        TreeNode parent = root;
        while (x != null) {
            if (x.val < key) {
                parent = x;
                x = x.right;
            } else if (x.val > key) {
                parent = x;
                x = x.left;
            } else {
                break;
            }
        }
        if (x == null) {
            return root.left;
        }
        if (x.left == null) {
            transplant(parent, x, x.right);
        } else if (x.right == null) {
            transplant(parent, x, x.left);
        } else {
            TreeNode minParent = x;
            TreeNode min = minParent.right;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            if (min != x.right) {
                minParent.left = min.right;
                min.right = x.right;
            }
            min.left = x.left;
            transplant(parent, x, min);
        }
        return root.left;
    }

    private void transplant(TreeNode parent, TreeNode oldChild, TreeNode newChild) {
        if (parent.left == oldChild) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }
    }

    public static void main(String[] args) {
        Solution450 s = new Solution450();
        s.deleteNode(TreeUtil.from(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3);
    }
}
