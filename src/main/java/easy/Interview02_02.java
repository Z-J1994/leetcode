package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  20:11
 */
public class Interview02_02 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode value = head;
        for(int i = 0;i < k;i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            value = value.next;
        }
        return value.val;
    }

}
