package easy;

public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        if(nums[0] == nums[1]){
            return nums[1];
        }
        for(int i = 2;i < nums.length;i++){
            //一共有n+1个元素,当2n > 4时必定有两个元素相同的距离不超过2
            if(nums[i] == nums[i - 1] || nums[i] == nums[i - 2]){
                return nums[i];
            }
        }
        //当2n == 4 时要考虑[a,b,c,a]
        return nums[0];
    }
}
