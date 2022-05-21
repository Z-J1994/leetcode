package medium;

import tree.TreeNode;
import tree.TreeUtil;

import java.util.NoSuchElementException;

public class Solution449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                sb.append(t.val);
                queue.offer(t.left);
                queue.offer(t.right);
            }
            sb.append(",");
        }
        int length = sb.length() - 1;
        while (length >= 0 && sb.charAt(length) == ',') {
            length--;
        }
        sb.setLength(length + 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        char [] chars = data.toCharArray();
        Queue<TreeNode> queue = new Queue<>();
        TreeNode root;
        int index = 0;
        int value = 0;
        while(index < chars.length && chars[index] != ','){
            value = value * 10 + chars[index++] - '0';
        }
        root = new TreeNode(value);
        queue.offer(root);
        while(++index < chars.length){
            TreeNode node = queue.poll();
            value = 0;
            if(chars[index] != ','){
                while(index < chars.length && chars[index] != ','){
                    value = value * 10 + chars[index++] - '0';
                }
                node.left = new TreeNode(value);
                queue.offer(node.left);
            }
            value = 0;
            if(++index < chars.length && chars[index] != ','){
                while(index < chars.length && chars[index] != ','){
                    value = value * 10 + chars[index++] - '0';
                }
                node.right = new TreeNode(value);
                queue.offer(node.right);
            }
        }
        return root;
    }

    private static class Queue<E> {

        private Object[] elements;

        private int head;

        private int tail;

        private int mask;

        private Queue(int capacity) {
            elements = new Object[capacity];
            mask = capacity - 1;
        }

        private Queue() {
            this(16);
        }

        private boolean isEmpty() {
            return head == tail;
        }

        private void offer(E element) {
            if (((tail + 1) & mask) == head) {
                grow(elements.length << 1);
            }
            elements[tail] = element;
            tail = (tail + 1) & mask;
        }

        @SuppressWarnings("unchecked")
        private E poll() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            Object result = elements[head];
            head = (head + 1) & mask;
            return (E) result;
        }

        private void grow(int capacity) {
            Object[] newElements = new Object[capacity];
            int index = 0;
            while (head != tail) {
                newElements[index++] = elements[head];
                head = (head + 1) & mask;
            }
            mask = capacity - 1;
            head = 0;
            tail = index;
            elements = newElements;
        }
    }


    public static void main(String[] args) {
        Solution449 s = new Solution449();
        s.deserialize(s.serialize(TreeUtil.from(new Integer[]{2,1})));
        s.deserialize(s.serialize(null));

    }
}
