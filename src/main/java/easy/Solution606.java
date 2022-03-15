package easy;

import tree.TreeNode;

public class Solution606 {
    public String tree2str(TreeNode root) {
        sb.append(root.val);
        if(root.left == null && root.right != null){
            sb.append("()");
        }
        preOrder(root.left);
        preOrder(root.right);
        return sb.toString();
    }
    private StringBuilder sb = new StringBuilder();
    private void preOrder(TreeNode root){
        if(root != null){
            sb.append("(").append(root.val);
            if(root.left == null && root.right != null){
                sb.append("()");
            }
            preOrder(root.left);
            preOrder(root.right);
            sb.append(")");
        }
    }
}
