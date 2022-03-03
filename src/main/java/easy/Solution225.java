package easy;

/**
 * @author zhangjun
 * @version 2022/3/3
 */
public class Solution225 {
    private static class MyStack {

        private final int[] q1 = new int[100];
        private int t1 = -1;

        private final int[] q2 = new int[100];
        private int t2 = -1;

        private boolean mark = true;

        public MyStack() {

        }

        public void push(int x) {
            if (mark) {
                q1[++t1] = x;
            } else {
                q2[++t2] = x;
            }
        }

        public int pop() {
            int result;
            if (mark) {
                for (int i = 0; i < t1; i++) {
                    q2[++t2] = q1[i];
                }
                result = q1[t1];
                t1 = -1;
                mark = false;
            } else {
                for (int i = 0; i < t2; i++) {
                    q1[++t1] = q2[i];
                }
                result = q2[t2];
                t2 = -1;
                mark = true;
            }
            return result;
        }

        public int top() {
            int result;
            if (mark) {
                for (int i = 0; i <= t1; i++) {
                    q2[++t2] = q1[i];
                }
                result = q1[t1];
                t1 = -1;
                mark = false;
            } else {
                for (int i = 0; i <= t2; i++) {
                    q1[++t1] = q2[i];
                }
                result = q2[t2];
                t2 = -1;
                mark = true;
            }
            return result;
        }

        public boolean empty() {
            return t2 == t1;
        }
    }
}
