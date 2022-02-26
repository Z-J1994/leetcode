package easy;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int result = -1;
        for(int i = 1,c;i < nums.length;i++){
            if(nums[i] <= min){
                min = nums[i];
            }else if((c = nums[i] - min) > result){
                result = c;
            }
        }
        return result;
    }
}
