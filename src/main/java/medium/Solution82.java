package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @date 2021/3/25
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode f = new ListNode(-101, head);
        ListNode p = f;
        while (p.next != null && p.next.next != null) {
            int v = p.next.val;
            if (v == p.next.next.val) {
                ListNode n;
                for (n = p.next.next.next; n != null && n.val == v; n = n.next) ;
                p.next = n;
            } else {
                p = p.next;
            }
        }
        return f.next;
    }
}
