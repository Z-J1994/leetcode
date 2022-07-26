package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2022/7/21 12:26
 */
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val == 0 && root.left == root.right) ? null : root;
    }
}
