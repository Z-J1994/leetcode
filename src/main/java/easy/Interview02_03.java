package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  9:57
 */
public class Interview02_03 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
