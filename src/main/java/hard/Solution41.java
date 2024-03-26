package hard;

/**
 * @author zhangjun
 * @since 2024/3/26 13:25
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0, s = nums.length; i < s; i++) {
            if (nums[i] - 1 == i) {
                continue;
            }
            if (nums[i] > 0 && nums[i] <= s && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
                --i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
