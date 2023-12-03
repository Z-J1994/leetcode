package medium;

/**
 * @author zhangjun
 * @date 2021/2/6
 */
public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i = 0;i < k;i++){
            sum += cardPoints[i];
        }
        if(k-- == cardPoints.length){
            return sum;
        }
        int max = sum;
        for(int i = 0,l = cardPoints.length - 1;i <= k;i++){
            sum = sum - cardPoints[k - i] + cardPoints[l - i];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
