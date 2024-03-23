package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/20  17:13
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode nh = head,sn;
        while(slow != null){
            sn = slow.next;
            slow.next = nh.next;
            nh.next = slow;
            nh = slow.next;
            slow = sn;
        }
        nh.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode p = null;
        for(ListNode next;head != null;){
            next = head.next;
            head.next = p;
            p = head;
            head = next;
        }
        return p;
    }

    public static void main(String[] args) {
        Solution143 s = new Solution143();
        ListNode l;
        l = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        s.reorderList(l);
    }
}
