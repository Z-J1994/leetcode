package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2021/9/22
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while(current != null){
            current = current.next;
            length++;
        }
        int l = length / k;
        int r = length % k;

        ListNode[] result = new ListNode[k];
        for(int i = 0;i < k;i++){
            result[i] = head;
            for(int j = (--r >= 0) ? 0 : 1;j < l && head != null;j++){
                head = head.next;
            }
            if(head != null){
                current = head;
                head = head.next;
                current.next = null;
            }
        }
        return result;
    }
}
