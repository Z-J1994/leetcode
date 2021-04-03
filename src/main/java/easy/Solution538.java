package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  19:23
 */
public class Solution538 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        recursion(root);
        return root;
    }

    public void recursion(TreeNode root){
        if(root != null){
            recursion(root.right);
            sum += root.val;
            root.val = sum;
            recursion(root.left);
        }
    }
}
