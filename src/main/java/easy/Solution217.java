package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2022/1/19
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }
}
