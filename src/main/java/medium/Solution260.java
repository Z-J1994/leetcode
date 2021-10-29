package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            Integer t =  map.get(n);
            if(t == null){
                t = 0;
            }
            map.put(n,t + 1);
        }

        int [] result = new int[2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result[i++] = entry.getKey();
                if(i == 2){
                    return result;
                }
            }
        }

        return null;
    }
}
