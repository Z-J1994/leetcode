package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2021/9/2
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode value = head;
        for(int i = 0;i < k;i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            value = value.next;
        }
        return value;
    }
}
