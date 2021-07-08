package medium;

/**
 * @author zhangjun
 * @version 2021/7/8
 */
public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for(int i = 0,l = nums.length;i < l;i++){
            int sum = 0;
            for(int j = i;j < l;j++){
                sum += nums[j];
                if(sum == goal){
                    ++count;
                }else if(sum > goal){
                    break;
                }
            }
        }
        return count;
    }
}
