package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/29  20:55
 */
public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) {
            return root;
        }
        if(root == p || root == q) {
            return root;
        }
        return left == null ? right : left;
    }

}
