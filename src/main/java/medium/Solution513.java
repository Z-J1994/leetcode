package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2022/6/22 12:40
 */
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return element;
    }

    private int level = 0;
    private int element = 0;

    private void dfs(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(level > this.level){
            this.level = level;
            element = root.val;
        }

        level++;
        dfs(root.left,level);
        dfs(root.right,level);
    }
}
