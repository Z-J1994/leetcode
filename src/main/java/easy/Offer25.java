package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/09/25  0:41
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode temp = first;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }

        if(l2 != null){
            temp.next = l2;
        }
        return first.next;
    }
}
