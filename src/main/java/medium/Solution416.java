package medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/10/11  20:43
 */
public class Solution416 {
    private int s;
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return false;
        }
        for(int i =0;i < length;i++){
            s += nums[i];
        }
        if((s & 0x1) == 1){
            return false;
        }
        Arrays.sort(nums);

        return recursion(nums,0,length - 1,0);
    }

    private boolean recursion(int [] nums,int lo,int hi,int sum){
        if(lo <= hi){
            boolean result = false;
            for(int i = lo;i <= hi;i++){
                if(i > lo && nums[i] == nums[i - 1]){
                    continue;
                }
                int t = (sum + nums[i]) << 1;
                if(t == s){
                    return true;
                }else if(t > s){
                    return false;
                }
                result = recursion(nums,i + 1,hi,sum + nums[i]);
                if(result){
                    break;
                }
            }
            return result;
        }
        return false;
    }
}
