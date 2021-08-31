package medium;

/**
 * @author zhangjun
 * @version 2021/8/31
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        for(int i = n - 1;i >= 0;i--){
            if(nums[i] + i >= n){
                n = i;
            }
        }
        return n == 0;
    }
}
