package easy;

import list.ListNode;

/**
 *
 * @author zhangjun
 * @version 2020/10/02  19:41
 */
public class Interview02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ta = headA;
        ListNode tb = headB;
        int la = 0;
        int lb = 0;
        while (ta != null) {
            la++;
            ta = ta.next;
        }
        while (tb != null) {
            lb++;
            tb = tb.next;
        }
        while (la < lb) {
            headB = headB.next;
            lb--;
        }
        while (la > lb) {
            headA = headA.next;
            la--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
