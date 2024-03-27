package medium;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if(k <= 1){
            return count;
        }
        for(int i = 0,j = 0,sum = 1;j < nums.length;j++){
            sum *= nums[j];
            while(sum >= k){
                sum /= nums[i++];
            }
            count += (j - i + 1);
        }
        return count;
    }
}
