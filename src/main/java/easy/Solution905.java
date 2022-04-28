package easy;

/**
 * @author zhangjun
 * @version 2020/09/29  19:42
 */
public class Solution905 {

    public int[] sortArrayByParity(int[] nums) {
        for(int i = -1,j = nums.length,t;;){
            while(++i < j && (nums[i] & 1) == 0);
            while(--j > i && (nums[j] & 1) == 1);
            if(i >= j){
                break;
            }
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return nums;
    }
}
