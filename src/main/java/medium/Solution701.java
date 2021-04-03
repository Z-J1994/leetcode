package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/30  14:43
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = put(root,val);
        return root;
    }

    private TreeNode put(TreeNode x,int value){
        if(x == null){
            return new TreeNode(value);
        }
        if(value < x.val){
            x.left = put(x.left,value);
        }else if(value > x.val){
            x.right = put(x.right,value);
        }
        return x;
    }
}
