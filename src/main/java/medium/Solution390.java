package medium;

/**
 * @author zhangjun
 * @version 2022/1/2
 */
public class Solution390 {
    public int lastRemaining(int n) {
        int result = 1;
        int step = 1;
        while (n >= 4) {
            int t = n - 1 - (n & 1);
            result += t * step;
            n >>>= 1;
            step <<= 1;

            t = n - 1 - (n & 1);
            result -= t * step;
            n >>>= 1;
            step <<= 1;
        }
        if (n > 1) {
            result += (n - 1 - (n & 1)) * step;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution390 s = new Solution390();
        s.lastRemaining(9);
    }
}
