package easy;

import list.ListNode;

import java.util.ArrayList;

/**
 * @author zhangjun
 * @version 2020/09/27  23:15
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }

        return pre;
    }
}
