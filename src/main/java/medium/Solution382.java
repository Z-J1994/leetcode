package medium;

import list.ListNode;

public class Solution382 {
    static class Solution {
        private final int[] element = new int[10001];
        private int length = 0;

        public Solution(ListNode head) {
            while (head != null) {
                element[length++] = head.val;
                head = head.next;

            }
        }

        public int getRandom() {
            int index = (int) (Math.random() * length);
            return element[index];
        }
    }
}
