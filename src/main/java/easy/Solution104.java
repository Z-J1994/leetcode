package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  15:32
 */
public class Solution104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int N = 0;
    public int maxDepth(TreeNode root) {
        recursion(root,1);
        return N;
    }

    private void recursion(TreeNode root,int n){
        if(root != null){
            if(n > N){
                N = n;
            }
            recursion(root.left,n+1);
            recursion(root.right,n+1);
        }
    }
}
