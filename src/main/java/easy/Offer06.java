package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  14:41
 */
public class Offer06 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int [] result = new int[length];
        for(int i = length - 1;i >= 0;i--){
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
}
