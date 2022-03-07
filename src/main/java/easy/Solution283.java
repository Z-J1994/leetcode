package easy;

/**
 * @author zhangjun
 * @version 2022/3/7
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                zeroCount++;
            }else{
                nums[i - zeroCount] = nums[i];
            }
        }
        for(int i = nums.length - 1,l = i - zeroCount;i > l;i--){
            nums[i] = 0;
        }
    }
}
