package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @date 2021/3/25
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        head = new ListNode(1,head);
        ListNode p = head;
        while(p.next != null){
            int value = p.next.val;
            ListNode next = p.next.next;
            int count = 0;
            while(next != null && next.val == value){
                next = next.next;
                count++;
            }
            if(count != 0){
                p.next = next;
            }else{
                p = p.next;
            }
        }
        return head.next;
    }
}
