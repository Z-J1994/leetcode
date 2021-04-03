package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  16:44
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1;i < nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
