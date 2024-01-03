package medium;

public class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if(boardingCost * 4 <= runningCost){
            return -1;
        }
        int sum = 0;
        int max = 0;
        int maxIndex = -2;
        int c = 0,i = 0;
        for(int t = 0;i < customers.length;i++){
            c += customers[i];
            if(c > 4){
                t = 4;
                c -= 4;
            }else{
                t = c;
                c = 0;
            }
            sum += (t * boardingCost - runningCost);
            if(sum > max){
                max = sum;
                maxIndex = i;
            }
        }
        int t = c % 4;
        sum += (c - t) * boardingCost - (c / 4);
        i += c / 4 - 1;
        t = t * boardingCost - runningCost;
        if(t > 0){
            sum += t;
            i++;
        }
        if(sum > max){
            maxIndex = i;
        }
        return maxIndex + 1;
    }
}
