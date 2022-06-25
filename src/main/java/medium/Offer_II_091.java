package medium;

public class Offer_II_091 {
    public int minCost(int[][] costs) {
        int [][] dp = new int[2][3];
        int pj = 1;
        for(int i = 0,j;i < costs.length;i++){
            j = i & 1;
            dp[j][0] = Math.min(dp[pj][1],dp[pj][2]) + costs[i][0];
            dp[j][1] = Math.min(dp[pj][0],dp[pj][2]) + costs[i][1];
            dp[j][2] = Math.min(dp[pj][1],dp[pj][0]) + costs[i][2];
            pj = j;
        }
        return Math.min(Math.min(dp[pj][0],dp[pj][1]),dp[pj][2]);
    }
}
