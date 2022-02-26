package easy;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        int size = queue.size();
        while(!queue.isEmpty()){
            TreeNode n = queue.pop();
            if(n.left == null && n.right == null){
                break;
            }
            if(n.left != null){
                queue.offer(n.left);
            }
            if(n.right != null){
                queue.offer(n.right);
            }
            if(--size == 0){
                level++;
                size = queue.size();
            }
        }
        return level;
    }
}
