package easy;


public class Solution303 {
    class NumArray {
        int [] newNum;
        public NumArray(int[] nums) {
            int n = nums.length + 1;
            newNum = new int[n];
            for(int i = 1,t = 0;i < n;i++){
                t = t + nums[i - 1];
                newNum[i] = t;
            }
        }
        public int sumRange(int i, int j) {
            return newNum[j + 1] - newNum[i];
        }
    }
}
