package easy;


import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  18:31
 */
public class Offer52 {
//    2020/10/04  18:31
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null){
//            return  null;
//        }
//        ListNode ta = headA;
//        int la = 0;
//        while(ta != null){
//            la++;
//            ta = ta.next;
//        }
//
//        ListNode tb = headB;
//        int lb = 0;
//        while(tb != null){
//            lb++;
//            tb = tb.next;
//        }
//
//        ta = headA;
//        while(la > lb){
//            ta = ta.next;
//            --la;
//        }
//
//        tb = headB;
//        while(la < lb){
//            tb = tb.next;
//            --lb;
//        }
//
//        while(ta != tb){
//            ta = ta.next;
//            tb = tb.next;
//        }
//        return ta;
//    }

    //2021/7/21 21:03
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
