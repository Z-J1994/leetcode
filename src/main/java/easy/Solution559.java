package easy;

import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/28  16:36
 */
public class Solution559 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

//    int depth = 0;
//
//    public int maxDepth(Node root) {
//        recursion(root,0);
//        return depth;
//    }
//
//    private void recursion(Node root,int depth){
//        if(root != null){
//            if(depth > this.depth){
//                this.depth = depth;
//            }
//            if(root.children != null){
//                for(Node n : root.children){
//                    recursion(n,depth + 1);
//                }
//            }
//        }
//    }

    public int maxDepth(Node root) {
        if (root != null) {
            dfs(root, 1);
        }
        return max;
    }

    int max = 0;

    private void dfs(Node root, int depth) {
        if (root == null || root.children == null || root.children.isEmpty()) {
            if (depth > max) {
                max = depth;
            }
            return;
        }
        for (Node child : root.children) {
            dfs(child, depth + 1);
        }
    }

}
