package easy;

/**
 * @author zhangjun
 * @since 2024/4/9 13:14
 */
public class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0,t = tickets[k];
        for(int i = 0;i <= k;i++){
            total += Math.min(t,tickets[i]);
        }
        --t;
        for(int i = k + 1;i < tickets.length;i++){
            total += Math.min(t,tickets[i]);
        }
        return total;
    }
}
