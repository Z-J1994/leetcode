package medium;

/**
 * @author zhangjun
 * @version 2022/3/4
 */
public class Solution2104 {
    public long subArrayRanges(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = 1; i + j < nums.length; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                } else if (nums[i + j] < min) {
                    min = nums[i + j];
                }
                result += max - min;
            }
        }
        return result;
    }
}
