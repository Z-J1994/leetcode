package medium;

import tree.ITreeNode;
import utils.TreeUtil;

/**
 * @author zhangjun
 * @version 2020/09/28  22:48
 */
public class Solution117 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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
        if (root == null) {
            return null;
        }
        Node previousLevel = root;
        while (previousLevel != null && previousLevel.left == null && previousLevel.right == null) {
            previousLevel = previousLevel.next;
        }
        if (previousLevel == null) {
            return root;
        }
        Node validRoot = previousLevel;
        Node currentLevel = validRoot.left == null ? validRoot.right : validRoot.left;
        while (previousLevel != null) {
            if (previousLevel.left != null) {
                currentLevel.next = previousLevel.left;
                currentLevel = previousLevel.left;
            }
            if (previousLevel.right != null) {
                currentLevel.next = previousLevel.right;
                currentLevel = previousLevel.right;
            }
            previousLevel = previousLevel.next;
        }
        currentLevel.next = null;
        connect(validRoot.left == null ? validRoot.right : validRoot.left);
        return root;
    }

    public static void main(String[] args) {
        Solution117 s = new Solution117();
        Node n = TreeUtil.from(new Integer[]{1, 2, 3, 4, 5, null, 7}, (Node::new));
        s.connect(n);
        int t = 5;

    }
}
