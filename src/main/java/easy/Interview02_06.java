package easy;

import list.ListNode;

/**
 *
 * @author zhangjun
 * @version 2020/10/04  20:09
 */
public class Interview02_06 {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode t = head;
        while(t != null){
            length++;
            t = t.next;
        }
        ListNode previous = null;
        for(int i = 0;i < length / 2;i++){
            t = head;
            head = head.next;
            t.next = previous;
            previous = t;
        }
        if ((length & 0x1) == 1){
            head = head.next;
        }
        while(previous != null){
            if(previous.val != head.val){
                return false;
            }
            previous = previous.next;
            head = head.next;
        }
        return true;
    }
}
