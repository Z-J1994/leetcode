package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  15:53
 */
public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for(int i : position){
            odd += i & 1;
            even += 1 - (i & 1);
        }
        return Math.min(odd, even);
    }
}
