package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  15:40
 */
public class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for(int i = 0;i < nums.length;i += 2){
            length += nums[i];
        }
        int [] target = new int[length];
        for(int i = 0,j = 0;i < nums.length;i += 2){
            for(int k = 0;k < nums[i];k++){
                target[j++] = nums[i + 1];
            }
        }
        return target;
    }
}
