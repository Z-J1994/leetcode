package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/23  15:35
 */
public class Solution590 {

    private class Node {
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
    }
    public List<Integer> postorder(Node root) {
        dfs(root);
        return result;
    }
    private final List<Integer> result = new ArrayList<>();
    private void  dfs(Node root){
        if(root != null){
            for(Node c : root.children){
                dfs(c);
            }
            result.add(root.val);
        }
    }
}
