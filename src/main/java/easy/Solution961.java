package easy;

public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        int t = nums[0];
        int c = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == t){
                if(++c > 1){
                    return t;
                }
            }else {
                if(--c < 0){
                    t = nums[i];
                    c = 1;
                }
            }
        }
        t = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0;i--){
            if(nums[i] == t){
                return t;
            }
        }
        return nums[nums.length - 2];
    }
}
