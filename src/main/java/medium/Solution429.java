package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution429 {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>(1000);
        if(root == null){
            return result;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> l = new ArrayList<>();
        int size = queue.size();
        while(!queue.isEmpty()){
            Node t = queue.poll();
            l.add(t.val);
            for(Node n : t.children){
                queue.offer(n);
            }
            if(--size == 0){
                size = queue.size();
                result.add(l);
                l = new ArrayList<>();
            }
        }
        return result;
    }
}
