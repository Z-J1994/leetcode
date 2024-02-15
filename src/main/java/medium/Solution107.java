package medium;

import tree.TreeNode;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = 1;
        List<Integer> l = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            l.add(t.val);
            if(t.left != null){
                queue.offer(t.left);
            }
            if(t.right != null){
                queue.offer(t.right);
            }
            if(--size == 0){
                size = queue.size();
                list.add(l);
                l = new ArrayList<>();
            }
        }
        for(int i = 0,j = list.size() - 1;i < j;i++,j--){
            List<Integer> l1 = list.get(i);
            List<Integer> l2 = list.get(j);
            list.set(i,l2);
            list.set(j,l1);
        }
        return list;
    }
}
