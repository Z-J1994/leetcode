package easy;

/**
 * @author zhangjun
 * @version 2022/10/27
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for(int n : nums){
            if(n == 0){
                return 0;
            }
            negativeCount += (n >>> 31);
        }
        return (negativeCount & 1) == 1 ? -1 : 1;
    }
}
