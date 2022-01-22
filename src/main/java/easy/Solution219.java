package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2022/1/19
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k >= nums.length){
            k = nums.length - 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i <= k;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        k += 1;
        for(int i = k;i < nums.length;i++){
            set.remove(nums[i - k]);
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
