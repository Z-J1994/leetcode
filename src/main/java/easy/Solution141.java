package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  19:31
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode previous = new ListNode(0);
        ListNode newHead = previous;

        while(head.next != null){
            ListNode t = head;
            head = head.next;
            t.next = previous;
            previous = t;
        }

        if(head == newHead){
            return true;
        }

        return false;
    }
}
