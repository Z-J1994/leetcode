package easy;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2023/11/16 13:15
 */
public class Solution2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0, j, p; i < nums.length; ) {
            if (nums[i] > threshold || (nums[i] & 1) != 0) {
                i++;
                continue;
            }
            for (j = i + 1, p = 1; j < nums.length; j++, p = 1 - p) {
                if (nums[j] > threshold || (nums[j] & 1) != p) {
                    break;
                }
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2760 s = new Solution2760();
        System.out.println(s.longestAlternatingSubarray(Parser.StringToIntArray("[4,10,3]"), 10));
        System.out.println(s.longestAlternatingSubarray(Parser.StringToIntArray("[2,10,5]"), 7));
    }
}
