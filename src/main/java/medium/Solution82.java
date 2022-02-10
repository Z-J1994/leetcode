package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @date 2021/3/25
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        head = new ListNode(-101, head);
        ListNode current = head;
        while (current.next != null) {
            ListNode n = current.next.next;
            int value = current.next.val;
            while (n != null && value == n.val) {
                n = n.next;
            }
            if (current.next.next != n) {
                current.next = n;
            } else {
                current = current.next;
            }
        }
        return head.next;
    }
}
