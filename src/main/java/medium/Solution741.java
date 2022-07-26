package medium;

/**
 * @author zhangjun
 * @since 2022/7/19 13:29
 */
public class Solution741 {
    private static class MyCalendarTwo {

        private int[][] calendar;
        private int index = -1;

        public MyCalendarTwo() {
            calendar = new int[16][2];
        }

        public boolean book(int start, int end) {
            int[] c = new int[]{start, end};
            int[] overlapped = null;
            for (int i = 0; i <= index; i++) {
                int[] b = calendar[i];
                if (overlapped != null && !overlap(b, overlapped)) {
                    overlapped = null;
                }
                if (overlap(b, c)) {
                    if (overlapped != null) {
                        return false;
                    }
                    overlapped = b;
                }
            }
            if (index == calendar.length - 1) {
                int[][] temp = new int[calendar.length << 1][2];
                System.arraycopy(calendar, 0, temp, 0, calendar.length);
                calendar = temp;
            }
            insertion(c);
            index++;
            return true;
        }

        private void insertion(int[] c) {
            int i;
            for (i = index; i >= 0 && lt(c, calendar[i]); i--) {
                calendar[i + 1] = calendar[i];
            }
            calendar[i + 1] = c;
        }

        private boolean lt(int[] p, int[] q) {
            if (p[0] < q[0]) {
                return true;
            } else if (p[0] == q[0]) {
                return p[1] < q[1];
            }
            return false;
        }

        private boolean overlap(int[] b, int[] q) {
            return b[0] < q[1] && q[0] < b[1];
        }

        public static void main(String[] args) {
            MyCalendarTwo calendarTwo = new MyCalendarTwo();
            System.out.println(calendarTwo.book(10, 20));
            System.out.println(calendarTwo.book(50, 60));
            System.out.println(calendarTwo.book(10, 40));
            System.out.println(calendarTwo.book(5, 15));
            System.out.println(calendarTwo.book(5, 10));
            System.out.println(calendarTwo.book(25, 55));
        }
    }
}
