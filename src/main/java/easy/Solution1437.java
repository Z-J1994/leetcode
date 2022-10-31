package easy;

public class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        for(int i = 0,t = 0;i < nums.length;i++){
            if(nums[i] == 1){
                if(t > 0){
                    return false;
                }
                t = k;
            }else{
                t--;
            }
        }
        return true;
    }
}
