package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/10/02  19:54
 */
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if(root.left != null){
            if(root.left.val != root.val || !isUnivalTree(root.left)){
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val != root.val || !isUnivalTree(root.right)){
                return false;
            }
        }
        return true;
    }
}
