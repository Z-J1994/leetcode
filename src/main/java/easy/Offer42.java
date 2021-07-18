package easy;

/**
 * @author zhangjun
 * @version 2021/7/18
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i : nums){
            sum += i;
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
