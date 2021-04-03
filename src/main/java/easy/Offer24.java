package easy;

import list.ListNode;

/**
 *
 * @author zhangjun
 * @version 2020/09/23  15:41
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

}
