package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length >>> 1);
        for(int i = 0,t;i < nums.length;i++){
            t = nums[i] - 1;
            if(t >= 0){
                if(nums[t] == -1){
                    result.add(nums[i]);
                    nums[i] = -2;
                }else{
                    nums[i] = nums[t];
                    nums[t] = -1;
                    i--;
                }
            }
        }
        return result;
    }
}
