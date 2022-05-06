package medium;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int product = nums[0];
        int count = 0;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (product < k) {
                count += right - left;
                product *= nums[right++];
            } else{
                product /= nums[left++];
            }
        }
        while(product >= k && left < right){
            product /= nums[left++];
        }
        count += right - left;
        return count;
    }
}
