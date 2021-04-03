package hard;

public class Solution123 {
        public int maxProfit(int[] prices) {

            int length = prices.length;

            int Hold0One = 0;
            int Hold1One = -prices[0];
            int Hold0Two = 0;
            int Hold1Two = -prices[0];
            for(int i = 1;i < length;i++){
                int t = prices[i];
                if(Hold1Two + t > Hold0Two){
                    Hold0Two = Hold1Two + t;
                }
                if(Hold0One - t > Hold1Two){
                    Hold1Two = Hold0One - t;
                }

                if(Hold1One + t > Hold0One){
                    Hold0One = Hold1One + t;
                }

                if(-t > Hold1One){
                    Hold1One = -t;
                }
            }
            return Hold0Two;
        }
}
