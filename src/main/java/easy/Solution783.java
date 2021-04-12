package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2021/4/13
 */
public class Solution783 {
    public int minDiffInBST(TreeNode x) {
        inOrder(x);
        return min;
    }
    int min = Integer.MAX_VALUE;
    Integer last = null;
    private void inOrder(TreeNode x){
        if(x.left != null){
            inOrder(x.left);
        }
        if(last != null){
            int t = x.val - last;
            if(t < min){
                min = t;
            }
        }
        last = x.val;
        if(x.right != null){
            inOrder(x.right);
        }
    }
}
