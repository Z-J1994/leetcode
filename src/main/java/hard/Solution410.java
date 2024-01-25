package hard;

import utils.Parser;

public class Solution410 {
    public int splitArray(int[] nums, int k) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            nums[i] += nums[i - 1];
            dp[i] = nums[i];
        }
        int [] dp1 = new int[nums.length];
        for(int i = 1;i < k;i++){
            for(int e = i;e < nums.length;e++){
                dp1[e] = -1 >>> 1;
                for(int s = i;s <= e;s++){
                    dp1[e] = Math.min(Math.max(dp[s - 1] , nums[e] - nums[s - 1]),dp1[e]);
                }
            }
            int [] t = dp;
            dp = dp1;
            dp1 = t;
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution410 s = new Solution410();
        System.out.println(s.splitArray(Parser.StringToIntArray("[10,5,13,4,8,4,5,11,14,9,16,10,20,8]"),3) == 50);
    }
}
