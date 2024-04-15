package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2024/4/15 12:36
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        int temp = root.val * 10,s = 0;
        if(root.left != null){
            root.left.val += temp;
            s += sumNumbers(root.left);
        }
        if(root.right != null){
            root.right.val += temp;
            s += sumNumbers(root.right);
        }
        return s;
    }
}
