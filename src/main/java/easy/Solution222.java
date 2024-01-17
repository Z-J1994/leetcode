package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2024/1/17 13:15
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
