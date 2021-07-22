package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/7/22
 */
public class Solution138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node newHead = new Node(-1);
        Node current = newHead;
        Node h = head;
        while(h != null){
            current.next = new Node(h.val);
            current = current.next;
            map.put(h,current);
            h = h.next;
        }
        current = newHead.next;
        while(head != null){
            current.random = map.get(head.random);
            current = current.next;
            head = head.next;
        }

        return newHead.next;
    }
}
