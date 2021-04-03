package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  19:45
 */
public class Interview17_04 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int result = (1 + length) * length / 2;

        for(int i = 0;i < length;i++){
            result -= nums[i];
        }
        return result;
    }
}
