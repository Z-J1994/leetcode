package easy;

/**
 * @author zhangjun
 * @since 2023/12/27 13:29
 */
public class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = player1[0],sum2 = player2[0];
        for(int i = 1,t = (sum1 + 10) / 10 ,t1 = (sum2 + 10) / 10;i < player1.length;i++){
            sum1 += t * player1[i];
            sum2 += t1 * player2[i];
            if(player1[i] == 10 || player1[i - 1] == 10){
                t = 2;
            }else{
                t = 1;
            }
            if(player2[i] == 10 || player2[i - 1] == 10){
                t1 = 2;
            }else{
                t1 = 1;
            }
        }
        return sum1 > sum2 ? 1 : sum2 > sum1 ? 2 : 0;
    }
}
