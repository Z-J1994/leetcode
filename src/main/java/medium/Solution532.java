package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2022/6/16 13:09
 */
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for(int lo = 0,hi = 0,lp,rp,t;hi < nums.length;){
            if((t = nums[hi] - nums[lo]) > k){
                lp = nums[lo];
                while(++lo < hi && nums[lo] == lp);
            }else{
                if(hi == lo){
                    hi++;
                }else{
                    if(t == k){
                        result++;
                    }
                    rp = nums[hi];
                    while(++hi < nums.length && nums[hi] == rp);
                }
            }
        }
        return result;
    }
}
