package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution398 {
    static class Solution {

        private final Map<Integer,List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            for(int i = 0;i < nums.length;i++){
                List<Integer> l = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
                l.add(i);
            }
        }

        public int pick(int target) {
            List<Integer> l = map.get(target);
            if(l != null){
                int index = (int)(Math.random() * l.size());
                return l.get(index);
            }
            return -1;
        }
    }
}
