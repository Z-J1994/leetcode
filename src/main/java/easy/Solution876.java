package easy;


import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/09/28  22:40
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int index;
        for(index = 0;head != null;index++){
            temp = temp.next;
        }

        for(int i = 0;i <= index / 2;i++){
            head = head.next;
        }
        return head;
    }
}
