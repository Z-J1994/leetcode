package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  22:13
 */
public class Solution268 {
//    public int missingNumber(int[] nums) {
//        int length = nums.length;
//        int result = (1 + length) * length / 2;
//
//        for(int i = 0;i < length;i++){
//            result -= nums[i];
//        }
//        return result;
//    }

    public int missingNumber(int[] nums) {
//        int result = 0 ^ nums.length;
        int result = nums.length;
        for(int i = 0;i < nums.length;i++){
            result = result ^ nums[i] ^ i;
        }
        return result;
    }
}
