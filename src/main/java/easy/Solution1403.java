package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/30  21:10
 */
public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
        }
        sum >>>= 1;
        List<Integer> ressult = new ArrayList<>();
        for(int i = nums.length - 1, t = 0;i >= 0 && t <= sum;i--){
            t += nums[i];
            ressult.add(nums[i]);
        }
        return ressult;
    }
}
