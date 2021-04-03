package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @date 2021/3/18
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode previous = new ListNode();//哑节点 简化边界条件
        previous.next = head;
        head = previous;

        for(int i = 1;i < left;i++){
            previous = previous.next;
        }

        ListNode newHead = previous.next;
        ListNode last = newHead;

        ListNode next = newHead.next;
        for(int i = left;i < right;i++){
            ListNode t = next;
            next = next.next;
            t.next = newHead;
            newHead = t;
        }

        last.next = next;
        previous.next = newHead;

        return head.next;
    }

}
