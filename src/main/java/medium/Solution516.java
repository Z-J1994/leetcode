package medium;

/**
 * @author zhangjun
 * @version 2021/8/12
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        char [] chars = s.toCharArray();
        int[][] dp = new int[length][length];

        for(int i = length - 1;i >= 0;i--){
            dp[i][i] = 1;
            char c = chars[i];
            for(int j = i + 1;j < length;j++){
                if(c == chars[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
