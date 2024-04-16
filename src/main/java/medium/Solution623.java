package medium;

import tree.TreeNode;

public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val,root,null);
        }
        return dfs(root,val,depth);
    }

    private TreeNode dfs(TreeNode root, int val, int depth){
        if(root == null){
            return null;
        }
        if(depth == 2){
            root.left = new TreeNode(val,root.left,null);
            root.right = new TreeNode(val,null,root.right);
            return root;
        }
        root.left = addOneRow(root.left,val,--depth);
        root.right = addOneRow(root.right,val,depth);
        return root;
    }
}
