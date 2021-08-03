package medium;

/**
 * @author zhangjun
 * @version 2021/8/3
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        int max = 0x80000000;
        int min = 0x7FFFFFFF;
        for(int i = 0,l = nums.length;i < l;i++){
            if(max > nums[i]){
                end = i;
            }else{
                max = nums[i];
            }
        }

        for(int i = nums.length - 1;i >= 0;i--){
            if(min < nums[i]){
                start = i;
            }else{
                min = nums[i];
            }
        }

        int t = end - start;
        return t == 0 ? 0 : t + 1;
    }
}
