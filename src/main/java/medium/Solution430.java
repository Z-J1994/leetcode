package medium;

/**
 * @author zhangjun
 * @version 2021/9/24
 */
public class Solution430 {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    Node previous = new Node();
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node result = previous;
        dfs(head);
        Node next = result.next;
        result.next = null;
        next.prev = null;
        return next;
    }

    private void dfs(Node head){
        if(head == null){
            return;
        }
        previous.next = new Node();
        previous.next.prev = previous;
        previous = previous.next;
        previous.val = head.val;

        dfs(head.child);
        dfs(head.next);
    }
}
