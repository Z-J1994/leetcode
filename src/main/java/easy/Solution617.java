package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:23
 */
public class Solution617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        t1 = recursion(t1,t2);
        return t1;
    }

    private TreeNode recursion(TreeNode t1, TreeNode t2){
        if(t1 == null) {
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = recursion(t1.left, t2.left);
        t1.right = recursion(t1.right, t2.right);
        return t1;
    }
}
