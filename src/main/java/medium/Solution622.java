package medium;

/**
 * @author zhangjun
 * @since 2022/8/2 12:53
 */
public class Solution622 {
    private static class MyCircularQueue {

        private final int[] queue;
        int head;
        int tail;

        public MyCircularQueue(int k) {
            queue = new int[k + 1];
            head = 0;
            tail = 0;
        }

        public boolean enQueue(int value) {
            int index = (tail + 1) % queue.length;
            if (index == head) {
                return false;
            }
            queue[index] = value;
            tail = index;
            return true;
        }

        public boolean deQueue() {
            if (head == tail) {
                return false;
            }
            head = (head + 1) % queue.length;
            return true;
        }

        public int Rear() {
            if (head == tail) {
                return -1;
            }
            return queue[tail];
        }

        public int Front() {
            if (head == tail) {
                return -1;
            }
            return queue[(head + 1) % queue.length];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return ((tail + 1) % queue.length) == head;
        }
    }
}
