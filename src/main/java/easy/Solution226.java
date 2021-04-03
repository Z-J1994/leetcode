package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:19
 */
public class Solution226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        recursion(root);
        return root;
    }
    private void recursion(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursion(root.left);
            recursion(root.right);
        }
    }
}
