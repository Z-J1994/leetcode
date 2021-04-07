package medium;

/**
 * @author zhangjun
 * @version 2021/4/8
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int low = 0;
        int hi = nums.length - 1;
        int min = nums[low] > nums[hi] ? nums[hi] : nums[low];

        while(low <= hi){
            int mid = (low + hi) / 2;
            if(nums[low] > nums[hi]){
                if(nums[mid] >= nums[low]){
                    min = nums[hi] < min ? nums[hi] : min;
                    low = mid + 1;
                }else{
                    min = nums[mid] < min ? nums[mid] : min;
                    hi = mid - 1;
                }
            }else{
                min = nums[low] < min ? nums[low] : min;
                hi = low - 1;
            }
        }
        return min;
    }
}
