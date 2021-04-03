package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/13  17:22
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode t = new ListNode(0);
        t.next = head;
        head = t;

        while(t.next!= null && t.next.next != null){
            ListNode first = t.next;
            ListNode second = t.next.next;

            first.next = second.next;
            second.next = first;
            t.next = second;
            t = first;
        }
        return head.next;
    }
}
