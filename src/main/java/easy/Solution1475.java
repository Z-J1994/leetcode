package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  20:56
 */
public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int [] result = new int[prices.length];
        int [] stack = new int[prices.length + 1];
        int top = 0;
        for(int i = prices.length - 1;i >= 0;i--){
            while(top > 0 && stack[top] > prices[i]){
                top--;
            }
            result[i] = prices[i] - stack[top];
            stack[++top] = prices[i];
        }
        return result;
    }
}
