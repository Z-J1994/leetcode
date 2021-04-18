package easy;

/**
 * @author zhangjun
 * @version 2021/4/18
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int k = 0;
        for(int i = 1;i < length;i++){
            int t = nums[i];
            if(nums[k] != t){
                nums[++k] = t;
            }
        }
        return k + 1;
    }
}
