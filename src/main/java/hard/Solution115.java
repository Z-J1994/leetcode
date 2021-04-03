package hard;

/**
 * @author zhangjun
 * @date 2021/3/17
 */
public class Solution115 {
    int [][] dp;
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        dp = new int [sLength][tLength];
        for(int i = 0;i < sLength;i++){
            for(int j = 0;j < tLength;j++){
                dp[i][j] = -1;
            }
        }
        return dfs(s,t,0,0);
    }

    private int dfs(String s, String t,int start,int index){
        if(index >= t.length()){
            return 1;
        }
        char c = t.charAt(index);
        int length = s.length();
        int sum = 0;
        for(int i = start;i < length;i++){
            if(s.charAt(i) == c){
                if(dp[i][index] != -1){
                    sum += dp[i][index];
                }else{
                    int temp = dfs(s, t, i + 1, index + 1);
                    dp[i][index] = temp;
                    sum += temp;
                }
            }
        }
        return sum;
    }
}
