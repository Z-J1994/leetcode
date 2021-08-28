package easy;

/**
 * @author zhangjun
 * @version 2021/8/26
 */
public class Offer_II_101 {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int max = 0;
        for(int t : nums){
            if(t > max){
                max = t;
            }
            target += t;
        }
        if((target & 0x1) == 1){
            return false;
        }
        target >>>= 1;
        if(target < max){
            return false;
        }
        int n = nums.length;
        boolean [] dp = new boolean[target  + 1];
        dp[0] = true;
        for(int i = 0 ; i < n ;i++){
            int t = nums[i];
            for(int j = target;j >= t;j--){
                dp[j] =  dp[j] || dp[j - t];


            }
        }
        return dp[target];
    }
}
