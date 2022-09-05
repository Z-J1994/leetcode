package medium;

import tree.TreeNode;

public class Solution687 {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        int l = 0;
        if(root.left != null){
            l = dfs(root.left);
            if(root.val != root.left.val){
                l = 0;
            }
        }
        int r = 0;
        if(root.right != null){
            r = dfs(root.right);
            if(root.right.val != root.val){
                r = 0;
            }
        }
        if(l + r > max){
            max = l + r;
        }
        return Math.max(l,r) + 1;
    }
}
