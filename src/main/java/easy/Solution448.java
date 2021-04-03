package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @date 2021/2/13
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        byte [] map = new byte[length + 1];

        for(int i = 0;i < length;i++){
            map[nums[i]]++;
        }
        List<Integer> result = new ArrayList<>();
        length++;
        for(int i = 1;i < length;i++){
            if(map[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}
