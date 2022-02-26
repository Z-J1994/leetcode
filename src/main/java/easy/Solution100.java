package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null) != (q == null)){
            return false;
        }
        if(p == null){
            return true;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
