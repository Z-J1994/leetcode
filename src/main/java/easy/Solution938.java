package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/22  22:37
 */
public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int s = 0;
        if(root.val >= low && root.val <= high){
            return rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high) + root.val;
        }else if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }else {
            return rangeSumBST(root.left,low,high);
        }
    }
}
