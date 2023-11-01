package easy;

/**
 * @author zhangjun
 * @version 2023/1/19
 */
public class Solution2293 {
    public int minMaxGame(int[] nums) {
        for(int l = nums.length;l > 1;){
            l = l >>> 1;
            for(int i = 0,t = l - 1;i < t;i++){
                nums[i] =  Math.min(nums[i * 2],nums[i * 2 + 1]);
                i++;
                nums[i] = Math.max(nums[i * 2],nums[i * 2 + 1]);
            }
        }
        return nums.length == 1 ? nums[0] : Math.min(nums[0],nums[1]);
    }
}
