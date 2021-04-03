package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  20:19
 */
public class Offer27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        recursion(root);
        return root;
    }

    public void recursion(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursion(root.left);
            recursion(root.right);
        }
    }

}
