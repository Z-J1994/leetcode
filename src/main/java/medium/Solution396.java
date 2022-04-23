package medium;

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int target = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            target += i * nums[i];
        }
        int max = target;
        for(int l = nums.length - 1,i = l;i >= 0;i--){
            target -= l * nums[i] - (sum - nums[i]);
            max = Math.max(max,target);
        }
        return max;
    }
}
