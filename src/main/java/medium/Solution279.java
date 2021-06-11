package main.java.medium;

/**
 * @author zhangjun
 * @version 2021/6/11
 */
public class Solution279 {
    public int numSquares(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1,max = 0x7fffffff;i <= n;i++){
            dp[i] = max;
            for(int j = (int)Math.sqrt(i);j > 0;j--){
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
