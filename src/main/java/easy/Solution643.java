package easy;

/**
 * @author zhangjun
 * @date 2021/2/4
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        if(k > length){
            k = length;
        }
        int sum = 0;
        for(int i = 0;i < k;i++){
            sum += nums[i];
        }
        int max = sum;
        for(int i = k,j = 0;i < length;i++,j++){
            sum = sum + nums[i] - nums[j];
            max = sum > max ? sum : max;
        }
        return 1.0 * max / k;
    }
}
