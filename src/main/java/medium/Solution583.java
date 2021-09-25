package medium;

/**
 * @author zhangjun
 * @version 2021/9/25
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int [][] dp = new int [l1 + 1][l2 + 1];

        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();

        for(int i = 0;i < l1;i++){
            for(int j = 0;j < l2;j++){
                if(w1[i] == w2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1],dp[i + 1][j]);
                }
            }
        }
        int longest = dp[l1][l2] << 1;
        return l1 - longest + l2;
    }
}
