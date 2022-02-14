package medium;

/**
 * @author zhangjun
 * @version 2022/2/14
 */
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) >>> 1;
            if((mid & 1) == 0){
                if(mid > 0 && nums[mid - 1] == nums[mid]){
                    hi = mid - 1;
                }else if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]){
                    lo = mid + 1;
                }else{
                    return nums[mid];
                }
            }else{
                if(mid > 0 && nums[mid - 1] == nums[mid]){
                    lo = mid + 1;
                }else if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]){
                    hi = mid - 1;
                }else{
                    return nums[mid];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution540 s = new Solution540();
        s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
    }
}
