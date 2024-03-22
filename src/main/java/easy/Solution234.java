package easy;

import list.ListNode;

import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/04  20:32
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        int length = 0;
        ListNode slow = head, sp = new ListNode();
        for (ListNode fast = head; fast != null; length++) {
            fast = fast.next;
            if ((length & 1) == 0) {
                ListNode p = sp;
                sp = slow;
                slow = slow.next;
                sp.next = p;
            }
        }
        if ((length & 1) == 1) {
            sp = sp.next;
        }

        while (slow != null) {
            if (sp.val != slow.val) {
                return false;
            }
            sp = sp.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution234 s = new Solution234();
        ListNode l = new ListNode(1,new ListNode(2));
        System.out.println(s.isPalindrome(l) == false);

         l = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
        System.out.println(s.isPalindrome(l) == true);
        l = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(2,new ListNode(1)))));
        System.out.println(s.isPalindrome(l) == true);
    }
}
