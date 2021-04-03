package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/20  17:13
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t = slow;

        slow = t.next;
        t.next = null;
        fast = head;

        ListNode p = null;

        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = p;
            p = slow;
            slow = nextTemp;
        }
        slow = p;


        while (fast != null && slow != null) {
            p = fast.next;
            t = slow.next;

            fast.next = slow;
            fast = p;

            slow.next = fast;
            slow = t;
        }
    }

}
