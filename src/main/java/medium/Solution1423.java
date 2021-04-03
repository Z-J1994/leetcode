package medium;

/**
 * @author zhangjun
 * @date 2021/2/6
 */
public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int maxLeft = 0;
        for(int i = 0;i < k;i++){
            maxLeft += cardPoints[i];
        }
        int length = cardPoints.length;
        if(k == length){
            return maxLeft;
        }
        int max = maxLeft;
        int l = length - k;
        for(int i = length - 1;i >= l;i--){
            maxLeft += cardPoints[i] - cardPoints[--k];
            max = (maxLeft > max) ? maxLeft : max;
        }
        return max;
    }
}
