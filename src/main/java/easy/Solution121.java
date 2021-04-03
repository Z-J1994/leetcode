package easy;

public class Solution121 {
    public int maxProfit(int[] prices) {

        int max = 0;
        for(int i = prices.length - 1,sum = 0;i > 0;i--){
            sum += prices[i] - prices[i - 1];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 s = new Solution121();
        int [] a = {7,1,5,3,6,4};
        int [] b = {7,6,4,3,1};
        int [] c = {1,1,1,1,1,1};
        System.out.println(s.maxProfit(a));
        System.out.println(s.maxProfit(b));
        System.out.println(s.maxProfit(c));
    }
}
