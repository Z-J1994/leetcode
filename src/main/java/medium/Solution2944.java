package medium;

/**
 * @author zhangjun
 * @since 2025/1/24 13:39
 */
public class Solution2944 {

    public int minimumCoins(int[] prices) {
        if (prices.length == 1 || prices.length == 2) {
            return prices[0];
        }
        int cost = 0, free = 0,head = 0, tail = -1;
        int[][] stack = new int[prices.length][2];
        stack[++tail][0] = prices[0];
        stack[tail][1] = 2;
        for (int i = 1, s; i < prices.length; i++) {
            cost = (s = stack[head][0] + prices[i]);
            if (stack[head][1] < (i + 1)) {
                ++head;
            }
            free = stack[head][0];
            while (tail >= head && stack[tail][0] > s) {
                --tail;
            }
            stack[++tail][0] = s;
            stack[tail][1] = i * 2 + 2;

        }
        return Math.min(cost, free);
    }

    public static void main(String[] args) {
        Solution2944 s = new Solution2944();
        System.out.println(s.minimumCoins(new int[]{3, 1, 2}) == 4);
        System.out.println(s.minimumCoins(new int[]{1, 10, 1, 1}) == 2);
        System.out.println(s.minimumCoins(new int[]{26, 18, 6, 12, 49, 7, 45, 45}) == 39);
        System.out.println(s.minimumCoins(new int[]{1, 37, 19, 38, 11, 42, 18, 33, 6, 37, 15, 48, 23, 12, 41, 18, 27, 32}) == 37);
        System.out.println(s.minimumCoins(new int[]{1, 37, 19, 38, 11, 42, 18, 33, 6, 37, 15, 48, 23, 12, 41, 18, 27, 32}));
    }
}
