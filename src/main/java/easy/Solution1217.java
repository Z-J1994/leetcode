package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/10/01  15:53
 */
public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for(int i = 0;i < position.length;i++){
            if((position[i] & 0x1) == 0){
                even++;
            }
            else{
                odd++;
            }
        }

        return Math.min(odd,even);
    }

}
