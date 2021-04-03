package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:05
 */
public class Solution404 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        recursion(root);
        return sum;
    }

    private void recursion(TreeNode root){
        if(root != null){
            if (root.left != null && root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }
            recursion(root.left);
            recursion(root.right);
        }
    }
}
