package easy;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution155 {
    static class MinStack {
        private static class Node {
            private final int value;
            private Node next;

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        private Node values;
        private Node minValues;

        public MinStack() {
            values = new Node(0, null);
            minValues = new Node(0x7fffffff, null);
        }

        public void push(int val) {
            values = new Node(val, values);
            if (val <= minValues.value) {
                minValues = new Node(val, minValues);
            }
        }

        public void pop() {
            if (values.value == minValues.value) {
                Node t = minValues.next;
                minValues.next = null;
                minValues = t;
            }
            Node t = values.next;
            values.next = null;
            values = t;
        }

        public int top() {
            return values.value;
        }

        public int getMin() {
            return minValues.value;
        }
    }
}
