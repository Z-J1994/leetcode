package easy;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/09/20  19:15
 */
public class Solution1290 {


    public int getDecimalValue(ListNode head) {
        int x = 0;
        for(int i = 0;head != null;i++){
            x <<= 1;
            x |= head.val;
            head = head.next;
        }
        return x;
    }

}
