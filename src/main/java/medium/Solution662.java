package medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Wrapper> queue = new ArrayDeque<>();
        queue.offer(new Wrapper(root,1));
        int size = 1;
        int result = 1;
        while(!queue.isEmpty()){
            Wrapper w = queue.poll();
            int t = (w.index - 1) << 1;
            if(w.node.left != null){
                queue.offer(new Wrapper(w.node.left,t + 1));
            }
            if(w.node.right != null){
                queue.offer(new Wrapper(w.node.right,t + 2));
            }
            if(--size == 0 && (size = queue.size()) != 0){
                result = Math.max(result,queue.peekLast().index - queue.peekFirst().index + 1);
            }
        }
        return result;
    }

    private static class Wrapper{
        private final int index;
        private final TreeNode node;

        private Wrapper(TreeNode node,int index){
            this.node = node;
            this.index = index;
        }
    }
}
