package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  23:28
 */
public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while(numBottles >= numExchange){
            int t = numBottles / numExchange;
            numBottles %= numExchange;
            numBottles += t;
            count += t;
        }

        return count;
    }
}
