package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:37
 */
public class Solution938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        recursion(root, L, R);
        return sum;
    }

    private void recursion(TreeNode root, int L, int R){
        if(root != null){
            if(root.val < L){
                recursion(root.right,L,R);
                return;
            }
            if(root.val > R){
                recursion(root.left,L,R);
                return;
            }
            sum += root.val;
            recursion(root.right,L,R);
            recursion(root.left,L,R);
        }
    }

}
