package medium;

/**
 * @author zhangjun
 * @since 2022/7/5 12:51
 */
public class Solution729 {
    private static class MyCalendar {
        int[][] list;
        int size;
        public MyCalendar() {
            list = new int[1000][2];
            size = 0;
        }

        public boolean book(int start, int end) {
            for(int i = 0;i < size;i++){
                int [] phase = list[i];
                if(phase[0] < end && start < phase[1]){
                    return false;
                }
            }
            list[size++] = new int[]{start,end};
            return true;
        }
    }
}
