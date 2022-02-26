package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q){
        if((p == null) != (q == null)){
            return false;
        }
        if(p == null){
            return true;
        }
        return p.val == q.val && dfs(p.left,q.right) && dfs(p.right,q.left);
    }
}
