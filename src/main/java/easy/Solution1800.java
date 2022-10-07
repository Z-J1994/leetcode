package easy;

public class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int s = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > nums[i - 1]){
                s += nums[i];
            }else{
                if(s > max){
                    max = s;
                }
                s = nums[i];
            }
        }
        if(s > max){
            max = s;
        }
        return max;
    }
}
