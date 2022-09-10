package medium;

import tree.TreeNode;

public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(inRange(root.val,low,high)){
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
        if(root.val > high){
            return trimBST(root.left,low,high);
        }
        return trimBST(root.right,low,high);
    }

    private boolean inRange(int target,int low,int high){
        return target >= low && target <= high;
    }
}
