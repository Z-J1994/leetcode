package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  19:17
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode previous = head;
        ListNode current = previous.next;
        while(current != null){
            if(previous.val == current.val){
                previous.next = current.next;
            }else{
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
