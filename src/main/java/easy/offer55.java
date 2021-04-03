package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  20:23
 */
public class offer55 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int N = 0;

    public int maxDepth(TreeNode root) {
        recursion(root,0);
        return N;
    }

    private void recursion(TreeNode root,int depth){
        if(root != null){
            recursion(root.left,depth + 1);
            recursion(root.right,depth + 1);
        }else if(depth > N){
            N = depth;
        }
    }
}
