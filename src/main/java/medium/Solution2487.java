package medium;

import list.ListNode;
import utils.Parser;

/**
 * @author zhangjun
 * @since 2024/1/3 12:41
 */
public class Solution2487 {

    public ListNode removeNodes(ListNode head) {
        ListNode p = null;
        for (ListNode next; head != null; head = next) {
            next = head.next;
            head.next = p;
            p = head;
        }
        head = p;
        p = null;
        int max = 0;
        for (ListNode next; head != null; head = next) {
            next = head.next;
            if (head.val >= max) {
                max = head.val;
                head.next = p;
                p = head;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Solution2487 s = new Solution2487();
        System.out.println(s.removeNodes(Parser.toList("[5,2,13,3,8]")));
    }
}
