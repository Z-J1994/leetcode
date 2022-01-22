package hard;

/**
 * @author zhangjun
 * @version 2022/1/17
 */
public class Solution1220 {
    private static final int MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[2][5];
        dp[1][0] = 1;//a
        dp[1][1] = 1;//e
        dp[1][2] = 1;//i
        dp[1][3] = 1;//o
        dp[1][4] = 1;//u

        int index = 1;
        for (int i = n - 1; i > 0; i--) {
            index = index ^ 1;
            dp[index][0] = dp[index ^ 1][1];
            dp[index][1] = (dp[index ^ 1][0] + dp[index ^ 1][2]) % MOD;
            dp[index][2] = (dp[index ^ 1][0] + dp[index ^ 1][1] + dp[index ^ 1][3] + dp[index ^ 1][4]) % MOD;
            dp[index][3] = (dp[index ^ 1][2] + dp[index ^ 1][4]) % MOD;
            dp[index][4] = dp[index ^ 1][0];
        }
        return (int) ((dp[index][0] + dp[index][1] + dp[index][2] + dp[index][3] + dp[index][4]) % MOD);
    }

    public static void main(String[] args) {
        Solution1220 s = new Solution1220();
        s.countVowelPermutation(20000);
    }
}
