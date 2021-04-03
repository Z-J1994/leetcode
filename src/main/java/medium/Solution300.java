package medium;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int []dp = new int[length + 1];
        int max = 1;
        dp[max] = nums[0];
        for(int i = 1;i < length;i++){
            int t = nums[i];
            if(t > dp[max]){
                dp[++max] = t;
            }else{
                dp[lowerBound(nums,1,max - 1,t)] = t;
            }
        }
        return max;
    }

    private int lowerBound(int [] array,int lo,int hi,int key){
        while(lo <= hi){
            int m = lo + ((hi - lo) >> 1);
            if(array[m] < key){
                lo = m + 1;
            }else{
                hi = m - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution300 s = new Solution300();

        int[] nums1 = {10,9,2,5,3,7,101,18};
        int[] nums2 = {0,1,0,3,2,3};
        int[] nums3 = {7,7,7,7,7,7,7};
        int[] nums4 = {1};

        System.out.println(s.lengthOfLIS(nums1));//4
        System.out.println(s.lengthOfLIS(nums2));//4
        System.out.println(s.lengthOfLIS(nums3));//1
        System.out.println(s.lengthOfLIS(nums4));//1
    }
}
