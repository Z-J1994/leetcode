package easy;

/**
 * @author zhangjun
 * @version 2022/1/27
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}
