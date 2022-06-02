package utils;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeUtil {

    public static TreeNode from(Integer[] data) {
        if (data.length == 0) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(data[0]);
        queue.offer(root);
        for (int i = 1; i < data.length; i++) {
            TreeNode poll = queue.poll();
            if(data[i] != null){
                TreeNode left = new TreeNode(data[i]);
                poll.left = left;
                queue.offer(left);
            }
            if(++i < data.length && data[i] != null){
                TreeNode right = new TreeNode(data[i]);
                poll.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

}
