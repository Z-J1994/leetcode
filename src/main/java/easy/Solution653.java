package easy;

import tree.TreeNode;

public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        treeRoot = root;
        return dfs(root,k);
    }
    private  TreeNode treeRoot;
    private boolean dfs(TreeNode root,int k){
        if(root == null){
            return false;
        }
        return ((root.val << 1) != k && contains(treeRoot,k - root.val)) || dfs(root.left,k) || dfs(root.right,k);
    }

    private boolean contains(TreeNode root,int target){
        while(root != null){
            if(root.val > target){
                root = root.left;
            }else if(root.val < target){
                root = root.right;
            }else{
                return true;
            }
        }
        return false;
    }
}
