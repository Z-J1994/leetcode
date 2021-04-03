package medium;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * @author zhangjun
 * @version 2020/09/28  22:48
 */
public class Solution117 {
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
    private Node [] list;
    private int length = 0;
    public Node connect(Node root) {
        getLength(root,1);
        list = new Node[length];
        recursion(root,0);
        return root;
    }

    private void getLength(Node root,int depth){
        if(root != null){
            if (depth > length){
                length = depth;
            }
            getLength(root.right,depth + 1);
            getLength(root.left,depth + 1);
        }
    }

    private void recursion(Node root,int depth){
        if(root != null){
            recursion(root.right,depth + 1);
            root.next = list[depth];
            list[depth] = root;
            recursion(root.left,depth + 1);
        }
    }
}
