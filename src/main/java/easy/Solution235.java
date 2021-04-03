package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/27  23:45
 */
public class Solution235 {
    TreeNode target;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            recursion(root,q.val,p.val);
        }else{
            recursion(root,p.val,q.val);
        }

        return target;
    }

    private void recursion(TreeNode root, int p, int q){
        if(root != null){
            if(root.val > q){
                recursion(root.left,p,q);
            }
            if(root.val < p){
                recursion(root.right, p, q);
            }
            if(root.val >= p && root.val <= q){
                target = root;
            }
        }
    }

}
