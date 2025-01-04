package hard;

import utils.Invoker;

import java.util.Arrays;

public class Solution732 {

    class MyCalendarThree {

        private final int[][] orders = new int[400][2];

        private final int[] stack = new int[400];

        private int size = 0;

        private int max = 1;

        public MyCalendarThree() {

        }

        public int book(int startTime, int endTime) {
            int[] c = new int[]{startTime, endTime};
            insertionArray(c);
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                int[] t = orders[i];
                while (end > start && t[0] >= stack[start]) {
                    ++start;
                }
                insertion(t[1], end++);
                max = Math.max(end - start,max);
            }
            return max;
        }

        private void insertionArray(int[] c) {
            int i;
            for (i = size - 1; i >= 0 && orders[i][0] > c[0]; i--) {
                orders[i + 1] = orders[i];
            }
            orders[i + 1] = c;
            ++size;
        }

        private void insertion(int e, int size) {
            int i;
            for (i = size - 1; i >= 0 && stack[i] > e; i--) {
                stack[i + 1] = stack[i];
            }
            stack[i + 1] = e;
        }

    }

    public static void main(String[] args) {
        Object[] parameters = new Object[]{new int[]{}, new int[]{24, 40}, new int[]{27, 43}, new int[]{14, 29}, new int[]{30, 40}, new int[]{25, 39}, new int[]{6, 19}};
        System.out.println(Arrays.toString(Invoker.invoke(MyCalendarThree.class, parameters, new Integer[parameters.length], new String[]{"MyCalendarThree", "book", "book", "book", "book", "book", "book"})));
    }

}
