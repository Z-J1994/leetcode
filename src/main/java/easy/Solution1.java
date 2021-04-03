package easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhangjun
 * @version 2020/10/03  17:15
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i){
            int t = nums[i];
            Integer answer = map.get(target - t);
            if(answer != null){
                return new int[]{answer,i};
            }
            map.put(t,i);
        }
        return null;
    }

}
