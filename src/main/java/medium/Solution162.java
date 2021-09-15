package medium;

/**
 * @author zhangjun
 * @version 2021/9/15
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while(true){
            int mid = (lo + hi) >>> 1;
            int l = get(nums,mid - 1);
            int r = get(nums,mid + 1);
            if(nums[mid] >= l && nums[mid] >= r){
                return mid;
            }else if(nums[mid] < l && nums[mid] > r){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
    }

    private int get(int[] nums,int index){
        if(index < 0 || index >= nums.length){
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }
}
