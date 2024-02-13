package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2024/2/8 13:18
 */
public class Solution993 {
    private int l;

    private TreeNode parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        l = -1;
        return dfs(root,0,x,y);
    }

    private boolean dfs(TreeNode root, int level, int x, int y){
        boolean r = false;
        if(root.left != null){
            if(root.left.val == x || root.left.val == y){
                if(l != -1){
                    r = l == level && parent != root;
                }else{
                    l = level;
                    parent = root;
                }
            }else{
                r = dfs(root.left,level + 1,x,y);
            }
        }

        if(root.right != null){
            if(root.right.val == x || root.right.val == y){
                if(l != -1){
                    r |= l == level && parent != root;
                }else{
                    l = level;
                    parent = root;
                }
            }else{
                r |= dfs(root.right,level + 1,x,y);
            }
        }
        return r;
    }
}
