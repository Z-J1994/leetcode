package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/17 20:29
 */
public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if(n < 2){
            return n;
        }
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        int max = 0;
        int t;
        for(int i = 0,l = n / 2;i < l;i++){
            dp[i << 1] = dp[i];
            t = dp[i] + dp[i + 1];
            dp[(i << 1) + 1] = t;
            if(t > max){
                max = t;
            }
        }
        t = dp[n / 2];
        if(t > max){
            max = t;
        }
        if((n & 0x1) == 1){
            t = dp[n / 2] + dp[n / 2 + 1];
            if(t > max){
                max = t;
            }
        }
        return max;
    }
}
