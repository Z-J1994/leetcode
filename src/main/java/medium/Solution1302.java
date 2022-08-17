package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2022/8/17 12:45
 */
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        maxLevel = 0;
        sum = 0;
        dfs(root,0);
        return sum;
    }

    private int maxLevel;
    private int sum;

    private void dfs(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(level > maxLevel){
            sum = root.val;
            maxLevel = level;
        }else if(level == maxLevel){
            sum += root.val;
        }
        ++level;
        dfs(root.left,level);
        dfs(root.right,level);
    }
}
