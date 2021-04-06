package medium;

/**
 * @author zhangjun
 * @version 2021/4/7
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        if(n == 0){
            return false;
        }
        if(n == 1)
        {
            return nums[0] == target;
        }

        int low = 0;
        int hi = nums.length - 1;
        while(low <= hi){
            int mid = (low + hi) / 2;
            int mv = nums[mid];
            if(mv == target){
                return true;
            }

            if(mv == nums[low] && mv == nums[hi]){
                ++low;
                --hi;
            }else if(nums[low] <= mv){
                if(mv > target && target >= nums[low]){
                    hi = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if (mv < target && target <= nums[n - 1]) {
                    low = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

//    public boolean search(int[] nums, int target) {
//        return binarySearch(nums,target,0,nums.length - 1);
//    }
//
//    public boolean binarySearch(int[] nums, int target,int left,int right){
//        if(left > right){
//            return false;
//        }
//        int mid = (left + right) / 2;
//        if(nums[mid] == target){
//            return true;
//        }
//        if(nums[left] >= nums[right]){
//            return binarySearch(nums,target,left,mid - 1) || binarySearch(nums,target,mid + 1,right);
//        }
//        do{
//            if(nums[mid] < target){
//                left = mid + 1;
//            }else if(nums[mid] > target){
//                right = mid - 1;
//            }else{
//                return true;
//            }
//            mid = (left + right) / 2;
//        }while(left <= right);
//
//        return false;
//    }
}
