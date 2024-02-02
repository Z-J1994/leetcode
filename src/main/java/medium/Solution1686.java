package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2024/2/2 13:45
 */
public class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int [] [] values = new int[aliceValues.length][3];
        for(int i = 0;i < aliceValues.length;i++){
            values[i][0] = aliceValues[i] + bobValues[i];
            values[i][1] = aliceValues[i];
            values[i][2] = bobValues[i];
        }
        Arrays.sort(values,(a , b) -> a[0] - b[0]);

        int a = 0,b = 0;
        for(int i = aliceValues.length - 1,k = 1;i >= 0;i--, k = 1 - k){
            if((k & 1) == 1){
                a += values[i][1];
            }else{
                b += values[i][2];
            }
        }
        return Integer.compare(a, b);
    }
}
