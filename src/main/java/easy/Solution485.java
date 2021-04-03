package easy;

/**
 * @author zhangjun
 * @date 2021/2/15
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int max = 0;
        int count = 0;
        for(int i = 0;i < length;i++){
            if(nums[i] > 0){
                count++;
            }else{
                if(count > max){
                    max = count;
                }
                count = 0;
            }
        }
        max = (count > max ) ? count : max;
        return max;
    }
}
