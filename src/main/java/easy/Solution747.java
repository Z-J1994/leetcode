package easy;

/**
 * @author zhangjun
 * @version 2022/1/13
 */
public class Solution747 {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
        }
        int count = 0;
        int max = nums[maxIndex];
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0 || max / nums[i] >= 2){
                count++;
            }
        }
        return (count == nums.length - 1) ? maxIndex : -1;
    }
}
