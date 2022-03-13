package easy;

import tree.TreeNode;

public class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int max = 0;
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(l + r > max){
            max = l + r;
        }
        return Math.max(l,r) + 1;
    }
}
