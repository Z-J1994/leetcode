package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,ValueHolder> map = new HashMap<>();
        for(int n : nums){
            ValueHolder count = map.get(n);
            if(count == null){
                count = new ValueHolder(0);
                map.put(n,count);
            }
            count.value++;
        }
        int limit = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer,ValueHolder> entry : map.entrySet()){
            if(entry.getValue().value > limit){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static class ValueHolder{
        private int value;
        private ValueHolder(int value){
            this.value = value;
        }
    }
}
