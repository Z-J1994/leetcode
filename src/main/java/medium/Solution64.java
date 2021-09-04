package medium;

/**
 * @author zhangjun
 * @version 2021/9/4
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] dp = new int[m];
        for(int i = 1;i < m;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int j = 0;j < n;j++){
            dp[0] += grid[j][0];
            for(int i = 1;i < m;i++){
                if(dp[i] > dp[i - 1]){
                    dp[i] = grid[j][i] + dp[i - 1];
                }else{
                    dp[i] += grid[j][i];
                }
            }
        }
        return dp[m - 1];
    }
}
