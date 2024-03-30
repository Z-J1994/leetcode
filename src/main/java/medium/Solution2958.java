package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @since 2024/3/28 13:34
 */
public class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int longest = 0;
        for(int i = -1,j = 0,t;j < nums.length;j++){
            t = nums[j];
            int c = map.getOrDefault(t,0) + 1;
            map.put(t,c);
            if(c > k){
                while(nums[++i] != t){
                    map.put(nums[i],map.get(nums[i]) - 1);
                }
                map.put(t,map.get(t) - 1);
            }else{
                longest = Math.max(j - i,longest);
            }
        }
        return longest;
    }
}
