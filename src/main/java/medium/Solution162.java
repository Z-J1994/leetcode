package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @version 2021/9/15
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                if (mid == 0) {
                    return 0;
                }
                hi = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                if (mid == nums.length - 2) {
                    return mid + 1;
                }
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution162 s = new Solution162();
        System.out.println(s.findPeakElement(Parser.StringToIntArray("[1,2,3,1]")));
    }
}
