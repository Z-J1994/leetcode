package hard;

/**
 * @author zhangjun
 * @version 2021/4/10
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int low = 0;
        int hi = nums.length - 1;

        while(low < hi){
            int mid = (low + hi) / 2;
            if(nums[low] == nums[mid] && nums[hi] == nums[mid]){
                ++low;
                --hi;
            }else if(nums[mid] > nums[hi]){
                low = mid + 1;
            }else{
                hi = mid;
            }
        }

        return nums[low];
    }
}
