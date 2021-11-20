package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution594 {
    public int findLHS(int[] nums) {
        Map<Integer,IntHolder> dp = new HashMap<>();
        IntHolder holder;
        for(int n : nums){
            holder = dp.get(n);
            if(holder == null){
                holder = new IntHolder(1);
                dp.put(n,holder);
            }else{
                ++holder.value;
            }
        }
        int max = 0;
        IntHolder t;
        for(Map.Entry<Integer,IntHolder> entry : dp.entrySet()){
            if((t = dp.get(entry.getKey() - 1)) != null){
                max = Math.max(max,entry.getValue().value + t.value);
            }
            if((t = dp.get(entry.getKey() + 1)) != null){
                max = Math.max(max,entry.getValue().value + t.value);
            }
        }
        return max;
    }

    private static class IntHolder{
        private int value;
        private IntHolder(int value){
            this.value = value;
        }
    }
}
