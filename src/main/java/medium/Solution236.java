package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null){
            return root;
        }
        TreeNode l1 = lowestCommonAncestor(root.left,p,q);
        TreeNode l2 = lowestCommonAncestor(root.right,p,q);
        if(l1 != null && l2 != null){
            return root;
        }
        return l1 == null ? l2 : l1;
    }
}
