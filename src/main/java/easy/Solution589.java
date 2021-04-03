package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/24  23:27
 */
public class Solution589 {
    class Node {
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
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return list;
    }
    public void preOrder(Node root) {
        if(root != null){
            list.add(root.val);
            for(Node c : root.children){
                preOrder(c);
            }
        }
    }
}
