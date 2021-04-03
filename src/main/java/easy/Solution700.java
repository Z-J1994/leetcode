package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/24  22:37
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val > val){
            return searchBST(root.left,val);
        }else if(root.val < val){
            return searchBST(root.right,val);
        }

        return root;
    }
}
