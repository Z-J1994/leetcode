package medium;

import list.ListNode;

/**
 * @author zhangjun
 * @version 2020/10/04  16:59
 */
public class Solution2 {
    private int carry;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode result;
        ListNode temp = null;
        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            carry = 0;
            if(sum > 9){
                sum -= 10;
                carry = 1;
            }
            temp1.val = sum;
            temp2.val = sum;
            temp1 = temp1.next;
            temp = temp2;
            temp2 = temp2.next;

        }

        if(temp1 != null){
            result = l1;
        }else{
            result = l2;
        }

        temp = surplus(temp,temp1);
        temp = surplus(temp,temp2);

        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return result;
    }

    private ListNode surplus(ListNode temp,ListNode t){
        while(t!= null){
            int sum = t.val + carry;
            carry = 0;
            if (sum > 9){
                sum -= 10;
                carry = 1;
            }
            temp = t;
            t.val = sum;
            t = t.next;
        }
        return temp;
    }
}
