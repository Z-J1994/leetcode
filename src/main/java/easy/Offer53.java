package easy;

/**
 * @author zhangjun
 * @version 2021/7/16
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        int lo = 0,hi = nums.length - 1;
        if(hi == -1){
            return 0;
        }
        int lowerBound = lowerBound(nums,lo,hi,target);
        int upperBound = upperBound(nums,lo,hi,target);
        int result = upperBound - lowerBound + 1;
        if(nums[lowerBound] != target){
            result--;
        }
        if(nums[upperBound] != target){
            result--;
        }
        return result < 0 ? 0 : result;
    }

    private int lowerBound(int [] nums,int lo,int hi,int target){
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo == nums.length ? hi : lo;
    }

    private int upperBound(int [] nums,int lo,int hi,int target){
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] <= target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo == 0 ? lo : hi;
    }
}
