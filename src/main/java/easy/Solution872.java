package easy;

import tree.TreeNode;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        preOrder(root1);
        return postOrder(root2) && index == 0;
    }
    private final int [] nodes = new int[200];
    private int index = 0;
    private void preOrder(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                nodes[index++] = root.val;
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private boolean postOrder(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                return nodes[--index] == root.val;
            }
            return postOrder(root.right) && postOrder(root.left);
        }
        return true;
    }
}
