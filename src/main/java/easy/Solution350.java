package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/3/10
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] map = new int[1001];
        for(int i : nums1){
            map[i]++;
        }
        int [] result = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        for(int i : nums2){
            if(map[i]-- > 0){
                result[index++] = i;
            }
        }
        return Arrays.copyOf(result,index);
    }
}
