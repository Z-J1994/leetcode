package medium;

/**
 * @author zhangjun
 * @version 2022/1/25
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[lo] <= nums[hi]){
                if(nums[mid] > target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{
                if(nums[mid] > target){
                    if(target >= nums[lo]){
                        hi = mid - 1;
                    }else if(nums[mid] >= nums[lo]){
                        lo = mid + 1;
                    }else{
                        hi = mid - 1;
                    }
                }else{
                    if(nums[mid] >= nums[lo]){
                        lo = mid + 1;
                    }else if(target >= nums[lo]){
                        hi = mid - 1;
                    }else{
                        lo = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 s = new Solution33();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, -1) == -1);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8) == -1);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) == 4);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1) == 5);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2) == 6);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4) == 0);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5) == 1);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6) == 2);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7) == 3);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(s.search(new int[]{1}, 0) == -1);
        System.out.println(s.search(new int[]{1,3}, 3) == 1);
        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8) == 4);
    }
}
