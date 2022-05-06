package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  19:29
 */
public class Solution933 {
    private static class RecentCounter {

        private final int[] element;
        private int head;
        private int tail;

        public RecentCounter() {
            element = new int[3002];
        }

        public int ping(int t) {
            int f = t - 3000;
            while (head != tail && element[head] < f) {
                head = (head + 1) % 3002;
            }
            element[tail] = t;
            tail = (tail + 1) % 3002;
            if(tail > head){
                return tail - head;
            }
            return 3002 - head + tail;
        }

    }
}
