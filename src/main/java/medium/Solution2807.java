package medium;

import list.ListNode;

public class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode h = head;
        for(ListNode next;(next = h.next) != null;h = next){
            ListNode n =  new ListNode(gcd(h.val,next.val));
            h.next = n;
            n.next = next;
        }
        return head;
    }

    private int gcd(int a,int b){
        while(b > 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
