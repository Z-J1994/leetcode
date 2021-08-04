package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/8/4
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 2,l = nums.length;i < l;i++){
            int maxLength = nums[i];
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > maxLength){
                    count += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }
}
