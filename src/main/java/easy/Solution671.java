package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2021/7/27
 */
public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null){
            return -1;
        }
        int value = root.val;
        int left = root.left.val;
        int right = root.right.val;
        if(left == value){
            left = findSecondMinimumValue(root.left);
        }
        if(right == value){
            right = findSecondMinimumValue(root.right);
        }

        if(left == -1){
            return right;
        }
        if(right == -1){
            return left;
        }

        return left > right ? right : left;
    }
}
