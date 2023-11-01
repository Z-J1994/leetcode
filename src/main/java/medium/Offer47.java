package medium;

/**
 * @author zhangjun
 * @version 2023/3/8
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for(int i = 0,s = 0;i < grid[0].length;i++){
            s += grid[0][i];
            dp[0][i] = s;
        }
        for(int i = 1;i < grid.length;i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            for(int j = 1,l = grid[i].length;j < l;j++){
                dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
