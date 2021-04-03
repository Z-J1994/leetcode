package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/11/16  10:49
 */
public class Solution998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if(val > root.val){
            temp.left = root;
            return temp;
        }
        TreeNode current = root;
        while(current.right != null && val < current.right.val){
            current = current.right;
        }

        temp.left = current.right;
        current.right = temp;

        return root;
    }

}
