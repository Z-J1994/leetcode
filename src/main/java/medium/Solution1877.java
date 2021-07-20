package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/7/20
 */
public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 0,j = nums.length - 1;i < j;i++,j--){
            max = Math.max(nums[i] + nums[j],max);
        }
        return max;
    }
}
