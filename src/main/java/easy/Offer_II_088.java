package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 13:25
 */
public class Offer_II_088 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int a = 0,b = 0,c = 0;
        for(int i = 2;i <= length;i++){
            c = Math.min(a + cost[i - 2],b + cost[i - 1]);
            a = b;
            b = c;
        }
        return c;
    }
}
