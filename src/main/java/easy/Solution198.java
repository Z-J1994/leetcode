package easy;

public class Solution198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if (length > 2) {
            nums[2] += nums[0];
            for (int i = 3; i < length; i++) {
                nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            }
            return Math.max(nums[length - 1],nums[length - 2]);
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else{
            return nums[0];
        }
    }

    public static void main(String[] args) {
        Solution198 s = new Solution198();
        int[] nums = {1, 2, 3, 1};
        int[] nums1 = {2, 7, 9, 3, 1};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {0,1};
        int[] nums5 = {0,1,2};
        System.out.println(s.rob(nums));
        System.out.println(s.rob(nums1));
        System.out.println(s.rob(nums2));
        System.out.println(s.rob(nums3));
        System.out.println(s.rob(nums4));
        System.out.println(s.rob(nums5));

    }
}
