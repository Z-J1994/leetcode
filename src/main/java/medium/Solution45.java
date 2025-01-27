package medium;

/**
 * @author zhangjun
 * @since 2025/1/27 14:05
 */
public class Solution45 {
    public int jump(int[] nums) {
        int steps = 0;
        for (int i = 0, l = nums.length - 1, farthest = 0, max; farthest < l; steps++, farthest = max) {
            max = 0;
            while (i <= farthest) {
                max = Math.max(max, nums[i] + i);
                i++;
            }
        }
        return steps;
    }
}
