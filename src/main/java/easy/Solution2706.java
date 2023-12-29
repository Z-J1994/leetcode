package easy;

/**
 * @author zhangjun
 * @since 2023/12/29 13:06
 */
public class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        int a = 101, b = 101;
        for (int price : prices) {
            if (price <= a) {
                b = a;
                a = price;
            } else if (price < b) {
                b = price;
            }
        }
        int result = money - (a + b);
        return result < 0 ? money : result;
    }
}
