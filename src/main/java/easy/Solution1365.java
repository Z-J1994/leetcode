package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/20  15:59
 */
public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] a = new int[101];
        for(int i = 0;i < nums.length;i++){
            a[nums[i]]++;
        }

        for(int i = 1;i < 101;i++){
            a[i] += a[i-1];
        }

        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                nums[i] = a[nums[i] - 1];
            }
        }
        return nums;
    }

}
