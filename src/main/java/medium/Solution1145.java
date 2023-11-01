package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2023/2/3
 */
public class Solution1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xn = getNode(root,x);
        int left = calculate(xn.left);
        int right = calculate(xn.right);
        int half = n >>> 1;
        return left > half || right > half ||  left + right < half;
    }

    private TreeNode getNode(TreeNode root,int target){
        if(root == null || root.val == target){
            return root;
        }
        TreeNode t = getNode(root.left,target);
        return t == null ? getNode(root.right,target) : t;
    }

    private int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + calculate(root.left) + calculate(root.right);
    }
}
