package medium;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int [] m = new int[nums.length];
        m[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0;i--){
            if(nums[i] > m[i + 1]){
                m[i] = nums[i];
            }else{
                m[i] = m[i + 1];
            }
        }

        int min = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(min < nums[i]){
                if(m[i] > nums[i]){
                    return true;
                }
            }else{
                min = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution334 s = new Solution334();
        s.increasingTriplet(new int [] {1,5,0,4,1,3});
    }
}
