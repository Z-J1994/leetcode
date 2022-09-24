package medium;

/**
 * @author zhangjun
 * @since 2022/9/23 13:24
 */
public class Solution707 {
    private static class MyLinkedList {

        private final Node head;

        private int size;

        public MyLinkedList() {
            head = new Node(-1, null);
        }

        public int get(int index) {
            Node n = getNode(index);
            return n == null ? -1 : n.val;
        }

        public void addAtHead(int val) {
            linkAfter(head, val);
        }

        public void addAtTail(int val) {
            linkAfter(getNode(size - 1), val);
        }

        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                linkAfter(head, val);
            } else if (index <= size) {
                linkAfter(getNode(index - 1), val);
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            unlinkAfter(getNode(index - 1));
        }

        private void linkAfter(Node t, int val) {
            Node n = new Node(val, t.next);
            t.next = n;
            size++;
        }

        private void unlinkAfter(Node t) {
            t.next = t.next.next;
            size--;
        }

        private Node getNode(int index) {
            Node i = head;
            while (i != null && index >= 0) {
                i = i.next;
                index--;
            }
            return i;
        }


        private static class Node {
            private int val;
            private Node next;

            private Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
