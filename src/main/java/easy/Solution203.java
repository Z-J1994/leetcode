package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  20:19
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode current = new ListNode(0);
        current.next = head;
        head = current;
        while(current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head.next;
    }
}
