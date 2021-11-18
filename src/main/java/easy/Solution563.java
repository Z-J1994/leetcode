package easy;

import tree.TreeNode;

public class Solution563 {
    public int findTilt(TreeNode root) {
        if(root != null){
            dfs(root);
        }
        return sum;
    }
    int sum = 0;
    private void dfs(TreeNode root){
        int left = 0;
        int right = 0;
        if(root.left != null){
            dfs(root.left);
            left = root.left.val;
        }
        if(root.right != null){
            dfs(root.right);
            right = root.right.val;
        }

        root.val += left + right;
        sum += Math.abs(left - right);
    }
}
