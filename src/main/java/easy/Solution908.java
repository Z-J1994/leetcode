package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  15:17
 */
public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(max < nums[i]){
                max = nums[i];
            }
            if(min > nums[i]){
                min = nums[i];
            }
        }
        int result = max - min - 2 * k;
        if(result < 0){
            result = 0;
        }
        return result;
    }
}
