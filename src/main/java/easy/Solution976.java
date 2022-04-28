package easy;

import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int circumference = 0;
        for(int i = nums.length - 1,t;i >= 2;i--){
            if(nums[i] < (t = nums[i - 1] + nums[i - 2])){
                return nums[i] + t;
            }
        }
        return 0;
    }
}
