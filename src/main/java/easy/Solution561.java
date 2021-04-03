package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/26  20:47
 */
public class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
