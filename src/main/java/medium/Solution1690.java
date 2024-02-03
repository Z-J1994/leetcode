package medium;

import utils.Parser;

public class Solution1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int sign = 1 - (n & 1);
        for (int i = 0; i < n; i++) {
            dp[i][i] = sign * stones[i];
        }
        for (int i = 1; i < n; i++) {
            sign = 1 - sign;
            if (sign == 1) {
                for (int l = 0, r = l + i; r < n; l++, r++) {
                    dp[l][r] = Math.min(dp[l + 1][r] + stones[l], dp[l][r - 1] + stones[r]);
                }
            } else {
                for (int l = 0, r = l + i; r < n; l++, r++) {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        Solution1690 s = new Solution1690();
        System.out.println(s.stoneGameVII(Parser.StringToIntArray("[5,3,1,4,2]")) == 6);
        System.out.println(s.stoneGameVII(Parser.StringToIntArray("[7,90,5,1,100,10,10,2]")) == 122);
    }
}
