package medium;

import tree.TreeNode;

public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode r = new TreeNode(val);
            r.left = root;
            return r;
        }
        return dfs(root,val,depth);
    }

    private TreeNode dfs(TreeNode root, int val, int depth){
        if(root == null){
            return null;
        }
        if(depth == 2){
            TreeNode l = new TreeNode(val);
            TreeNode r = new TreeNode(val);

            l.left = root.left;
            r.right = root.right;
            root.left = l;
            root.right = r;
            return root;
        }
        depth--;
        root.left = dfs(root.left,val,depth);
        root.right = dfs(root.right,val,depth);
        return root;
    }
}
