package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }
    boolean result = true;
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(l - r < -1 || l - r > 1){
            result = false;
        }
        return Math.max(l,r) + 1;
    }
}
