package medium;

import utils.Parser;

import java.util.Arrays;

public class Solution2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        long [] dp = new long[n + 1];
        int j = 1;
        for(int [] ride : rides){
            while(j <= ride[0]){
                dp[j] = Math.max(dp[j],dp[j - 1]);
                j++;
            }
            dp[ride[1]] = Math.max(dp[ride[1]],dp[ride[0]] + ride[1] - ride[0] + ride[2]);
        }
        while(j <= n){
            dp[j] = Math.max(dp[j],dp[j - 1]);
            j++;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution2008 s = new Solution2008();
//        System.out.println(s.maxTaxiEarnings(20, Parser.stringToIntMatrix("[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]", 6, 3)) == 20);
        System.out.println(s.maxTaxiEarnings(10, Parser.stringToIntMatrix("[[2,3,6],[8,9,8],[5,9,7],[8,9,1],[2,9,2],[9,10,6],[7,10,10],[6,7,9],[4,9,7],[2,3,1]]", 10, 3)) == 33);
    }
}
