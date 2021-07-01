package easy;

/**
 * @author zhangjun
 * @version 2021/7/1
 */
public class LCP07 {
    public int numWays(int n, int[][] relation, int k) {
        int [][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1;i <= k;i++){
            for(int j = 0,l = relation.length;j < l;j++){
                dp[i][relation[j][1]] += dp[i - 1][relation[j][0]];
            }
        }
        return dp[k][n - 1];
    }
}
