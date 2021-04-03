package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  19:02
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }

        ListNode t = head;

        while(t.next != null && t.next.val != val){
            t = t.next;
        }
        if(t.next == null){
            return head;
        }
        t.next = t.next.next;
        return head;
    }

}
