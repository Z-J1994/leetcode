package medium;

/**
 * @author zhangjun
 * @version 2020/10/15  21:17
 */
public class Solution116 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        connect0(root);
        recursion(root);
        return root;
    }
    public Node connect0(Node root) {
        if(root != null){
            Node right = connect0(root.right);
            connect0(root.left);
            if(root.left != null){
                root.left.next = right;
            }
            return root;
        }
        return null;
    }
    public void recursion(Node root){
        if(root != null){
            recursion(root.left);

            if(root.next != null){
                Node right = root.right;
                Node left = root.next.left;
                while(right != null && left != null){
                    right.next = left;
                    right = right.right;
                    left = left.left;
                }
            }
            recursion(root.right);
        }
    }


}
