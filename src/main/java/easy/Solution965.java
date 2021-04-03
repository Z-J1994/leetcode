package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/10/02  19:54
 */
public class Solution965 {
    private boolean marked = true;
    public boolean isUnivalTree(TreeNode root) {
        preOrder(root);
        return marked;
    }
    private void preOrder(TreeNode root){
        if(root != null){
            if(root.left != null){
                if(root.val != root.left.val){
                    marked = false;
                    return;
                }
            }
            if(root.right != null){
                if(root.val != root.right.val){
                    marked = false;
                    return;
                }
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
