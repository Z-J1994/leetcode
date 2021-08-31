package medium;

/**
 * @author zhangjun
 * @version 2021/8/31
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] result = new int[n];
        for(int [] booking : bookings){
            int t = booking[2];
            result[booking[0] - 1] += t;
            if(booking[1] < n){
                result[booking[1]] += -t;
            }
        }
        for(int i = 1;i < n;i++){
            result[i] += result[i - 1];
        }
        return result;
    }
}
