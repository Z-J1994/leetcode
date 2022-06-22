package medium;


public class Offer_II_029 {


    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            n.next = n;
            head = n;
        } else if (head.next == head) {
            n.next = n;
            head.next = n;
            n.next = head;
        } else {
            Node pMin = null;
            int min = 0x7fffffff;
            Node c = head;
            int mark = 0;
            do {
                if (c.val <= insertVal && c.next.val >= insertVal) {
                    n.next = c.next;
                    c.next = n;
                    return head;
                }
                if (c.next.val < min) {
                    min = c.next.val;
                    pMin = c;
                } else if (c.next.val == min) {
                    if (mark == 1) {
                        pMin = c;
                        mark <<= 1;
                    }
                } else {
                    mark |= 1;
                }
                c = c.next;
            } while (c != head);
            n.next = pMin.next;
            pMin.next = n;
        }
        return head;
    }

}
