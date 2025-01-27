package medium;

import utils.Parser;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2025/1/15 13:23
 */
public class Solution3066 {

    public int minOperations(int[] intNums, int k) {
        int pivot = getPivot(intNums, k);
        long [] nums = copy(intNums, pivot);
        Arrays.sort(nums, 0, pivot);
        int operations = 0, start = 0, end = pivot - 1;
        while (start <= end) {
            long[] p = new long[2];
            int lo = start, hi = start - 1;
            for (int i = start, l; i <= end; ++operations) {
                l = 0;
                if (lo <= hi && nums[i] > nums[lo]) {
                    p[l++] = nums[lo++];
                } else {
                    p[l++] = nums[i++];
                }
                if (i > end) {
                    if (lo <= hi) {
                        long t  = Math.min(p[0], nums[lo]) * 2 + Math.max(p[0], nums[lo]);
                        if(t < k){
                            nums[++hi] = t;
                        }
                        ++lo;
                    } else {
                        hi = Integer.MIN_VALUE;
                    }
                    ++operations;
                    break;
                }
                if (lo <= hi && nums[i] > nums[lo]) {
                    p[l] = nums[lo++];
                } else {
                    p[l] = nums[i++];
                }
                long t = Math.min(p[0], p[1]) * 2 + Math.max(p[0], p[1]);
                if(t < k){
                    nums[++hi] = t;
                }
            }
            start = lo;
            end = hi;
        }
        return operations;
    }

    private static long [] copy(int[] original, int length){
        long [] nums = new long[length];
        for(int i = 0;i < length;i++){
            nums[i] = original[i];
        }
        return  nums;
    }

    private static int getPivot(int[] nums, int k) {
        int i = 0;
        for (int j = nums.length - 1; i < j; ) {
            while (i <= j && nums[i] < k) {
                ++i;
            }
            while (i < j && nums[j] >= k) {
                --j;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution3066 s = new Solution3066();
//        System.out.println(s.minOperations(Parser.StringToIntArray("[69,89,57,31,84,97,50,38,91,86]"), 91) == 4);
        System.out.println(s.minOperations(Parser.StringToIntArray("[2,11,10,1,3]"), 10) == 2);
    }
}
