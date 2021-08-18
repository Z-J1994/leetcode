package hard;

/**
 * @author zhangjun
 * @version 2021/8/18
 */
public class Solution552 {
    public int checkRecord(int n) {
        long [][][] dp = new long[2][2][3];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        int mod = 1000000007;
        for(int i = 1;i < n;i++){
            dp[map(i + 1)][0][0] = (dp[map(i)][0][0] + dp[map(i)][0][1] + dp[map(i)][0][2]) % mod;
            dp[map(i + 1)][1][0] = (dp[map(i)][1][0] + dp[map(i)][1][1] + dp[map(i)][1][2]) % mod;

            dp[map(i + 1)][0][1] = dp[map(i)][0][0];
            dp[map(i + 1)][0][2] = dp[map(i)][0][1];
            dp[map(i + 1)][1][1] = dp[map(i)][1][0];
            dp[map(i + 1)][1][2] = dp[map(i)][1][1];

            dp[map(i + 1)][1][0] += dp[map(i)][0][0] + dp[map(i)][0][1] + dp[map(i)][0][2];

        }

        return (int)((dp[map(n)][0][0] + dp[map(n)][0][1] + dp[map(n)][0][2] + dp[map(n)][1][0] + dp[map(n)][1][1] + dp[map(n)][1][2]) % mod);
    }

    private int map(int index){
        return (index & 0x1);
    }
}
