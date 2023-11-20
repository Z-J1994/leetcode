package medium;

/**
 * @author zhangjun
 * @since 2023/11/20 13:17
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = 0x80000000;
        for(int i = 0,sum = 0;i < nums.length;i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
