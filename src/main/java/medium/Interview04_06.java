package medium;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2022/5/16 13:29
 */
public class Interview04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            TreeNode t = p.right;
            while(t.left != null){
                t = t.left;
            }
            return t;
        }
        if(root == p){
            return null;
        }
        return dfs(root,null,p);
    }

    private TreeNode dfs(TreeNode root,TreeNode parent, TreeNode p){
        TreeNode r;
        if(root.val > p.val){
            if(root.left == p){
                return root;
            }
            r = dfs(root.left,root,p);
        }else{
            if(root.right == p){
                return parent;
            }
            r = dfs(root.right,root,p);
        }
        if(r != null && r.val > p.val){
            return r;
        }
        return parent;
    }
}
