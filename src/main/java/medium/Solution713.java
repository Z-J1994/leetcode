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

    public static void main(String[] args) {
        Solution713 s = new Solution713();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5,1000, 2, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5,1008, 2,1234, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19) == 18);
    }
}
