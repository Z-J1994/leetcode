package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  18:10
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l2 != null && l1 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = (l1 == null ? l2 : l1);

        return head.next;
    }
}
