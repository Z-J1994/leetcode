package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/7/2
 */
public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;

        for(int i = 0,l = costs.length;i < l;i++){
            coins -= costs[i];
            if(coins < 0){
                break;
            }
            count++;
        }
        return count;
    }
}
