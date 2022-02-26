package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            return true;
        }
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
