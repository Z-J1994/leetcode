package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @date 2021/3/27
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {

        ListNode current = head;
        int length = 0;
        while(current != null){
            if(k == length){
                break;
            }
            ++length;
            current = current.next;
        }
        if(current == head){
            return head;
        }
        if(current == null){
            k %= length;
            current = head;
            while(k > 0){
                --k;
                current = current.next;
            }
            if(current == head){
                return head;
            }
        }

        ListNode newHead = head;
        while(current.next != null){
            current = current.next;
            newHead = newHead.next;
        }
        ListNode oldHead = head;
        head = newHead.next;
        newHead.next = null;
        current.next = oldHead;
        return head;
    }
}
