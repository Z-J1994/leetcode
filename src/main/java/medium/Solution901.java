package medium;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution901 {
    private static class StockSpanner {
        private final int[][] stack;
        int top = -1;
        public StockSpanner() {
            stack = new int[2][10001];
        }

        public int next(int price) {
            int sum = 1;
            while(top >= 0 && stack[0][top] <= price){
                sum += stack[1][top];
                --top;
            }
            stack[0][++top] = price;
            stack[1][top] = sum;
            return sum;
        }
    }
}
