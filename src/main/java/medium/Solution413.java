package medium;

/**
 * @author zhangjun
 * @version 2021/8/10
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int count = 0;
        int begin = -1;
        int different = nums[1] - nums[0];
        for(int i = 2,l = nums.length;i < l;i++){
            int t = nums[i] - nums[i - 1];
            if(t != different){
                begin = -1;
                different = t;
            }else if(begin == -1){
                begin = i - 2;
                count++;
            }else{
                count += (i - 1) - begin;
            }
        }
        return count;
    }
}
