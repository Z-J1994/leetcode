package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/7/15
 */
public class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        for(int a : arr){
            if(a > max){
                max++;
            }
        }
        return max;
    }
}
