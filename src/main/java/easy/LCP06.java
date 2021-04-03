package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:50
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int count = 0;
        for(int i = 0;i < coins.length;i++){
            count += coins[i] / 2;
            if(coins[i] % 2 == 1){
                count++;
            }
        }
        return count;
    }
}
