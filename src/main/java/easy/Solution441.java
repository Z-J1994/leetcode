package easy;

/**
 * @author zhangjun
 * @version 2021/10/10
 */
public class Solution441 {
    public int arrangeCoins(int n) {
        long n1 = n;
        n1 = n1 << 1;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            long t = (long) mid * mid + mid;
            if (t > n1) {
                hi = mid - 1;
            } else if (t < n1) {
                lo = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return hi;
    }
}
