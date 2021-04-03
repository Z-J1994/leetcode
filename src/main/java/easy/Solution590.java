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
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        recursion(root);
        return list;
    }

    private void recursion(Node root){
        if(root != null){
            if(root.children != null){
                for(Node node : root.children){
                    recursion(node);
                }
            }
            list.add(root.val);
        }
    }
}
