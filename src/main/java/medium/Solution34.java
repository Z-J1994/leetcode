package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/1/25
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (hi >= nums.length || nums[hi] != target) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        result[0] = hi;

        lo = -1;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + ((hi - lo) & 1);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        result[1] = lo;
        return result;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));//[3,4]
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));//[0,0]
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));//[1,2]
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)));//[5,5]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 1)));//[0]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 2)));//[1]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 3)));//[2]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 4)));//[3]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 5)));//[4]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 6)));//[5]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 7)));//[6]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 8)));//[7]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 9)));//[8]
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,4,5,6,7,8,9}, 10)));//[-1]


        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,5,6,7,8,9}, 4)));//[-1]
    }
}
