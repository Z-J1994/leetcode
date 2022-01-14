package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/1/14
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = Math.min(nums1.length, k);
        int[] n = new int[length];
        while (k > 0) {
            int firstIndex = -1;
            while (++firstIndex < length && n[firstIndex] == nums2.length);
            if(firstIndex == length){
                return result;
            }
            for(int i = firstIndex + 1;i < length;i++){
                if(n[i] < nums2.length && nums1[i] + nums2[n[i]] < nums1[firstIndex] + nums2[n[firstIndex]]){
                    firstIndex = i;
                }
            }
            result.add(Arrays.asList(nums1[firstIndex],nums2[n[firstIndex]]));
            ++n[firstIndex];
            --k;
        }
        return result;
    }
}
