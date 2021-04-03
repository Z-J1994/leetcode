package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  20:56
 */
public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        for(int i = 0,j;i < prices.length;i++){
            for(j = i + 1;j < prices.length;j++){
                if(prices[i] >= prices[j]){
                    prices[i] -= prices[j];
                    break;
                }
            }

        }
        return prices;
    }
}
