package medium;

/**
 * @author zhangjun
 * @version 2021/4/6
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length <= 2){
            return length;
        }
        int left = 1;
        for(int right = 2;right < length;++right){
            if(nums[left - 1] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }
}
