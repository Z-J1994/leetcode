package medium;

import tree.TreeNode;

import java.util.*;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int size = 1;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            root = queue.poll();
            list.add(root.val);
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
            if(--size == 0){
                size = queue.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}
