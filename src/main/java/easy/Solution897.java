package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/26  17:42
 */
public class Solution897 {
    TreeNode root;
    TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
        this.root = new TreeNode(root.val);
        current = this.root;
        inOrder(root);
        return this.root.right;
    }
    private void inOrder(TreeNode x){
        if(x != null){
            inOrder(x.left);
            x.left = null;
            current.right = x;
            current = current.right;
            inOrder(x.right);
        }
    }

}
