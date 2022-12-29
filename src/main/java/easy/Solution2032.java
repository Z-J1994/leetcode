package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution2032 {
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int [] map = new int[101];
            for (int j : nums1) {
                map[j] |= 1;
            }
            for (int k : nums2) {
                map[k] |= 2;
            }
            for (int j : nums3) {
                map[j] |= 4;
            }
            List<Integer> result = new ArrayList<>(100);
            for(int i = 1;i <= 100;i++){
                if(map[i] > 2 && map[i] != 4){
                    result.add(i);
                }
            }
            return result;
        }
    }
}
