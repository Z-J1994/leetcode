package medium;

import utils.Parser;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/12/20
 */
public class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int lo = 0,hi = nums.length;
        long t;
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            t = calculate(nums,mid + 1,nums[mid]);
            if(t > maxOperations){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        t = calculate(nums,hi + 1,nums[hi]);
        if(t < maxOperations){
            lo = 1;
            hi = nums[hi];
            while(lo < hi){
                int mid = (lo + hi) >>> 1;
                if(calculate(nums,0,mid) > maxOperations){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            return hi;
        }
        return nums[hi];
    }

    private long calculate(int[] nums, int start,int divisor) {
        long t = -(nums.length - start);
        while (start < nums.length) {
            t += (nums[start++] + divisor - 1) / divisor;
        }
        return  t;
    }

    public static void main(String[] args) {
        Solution1760 s = new Solution1760();
        System.out.println(s.minimumSize(Parser.StringToIntArray("[9]"), 2) == 3);
        System.out.println(s.minimumSize(Parser.StringToIntArray("[431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26]"), 80) == 129);
        System.out.println(s.minimumSize(Parser.StringToIntArray("[421]"), 1) == 211);
    }
}
