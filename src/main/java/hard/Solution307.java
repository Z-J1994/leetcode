package hard;

public class Solution307 {

    private static class NumArray {
        private final int[] nums;

        private final int[] originalNums;

        public NumArray(int[] nums) {
            originalNums = nums;
            this.nums = new int[nums.length];
            for (int i = 0, sum = 0; i < nums.length; i++) {
                sum += nums[i];
                this.nums[i] = sum;
            }
        }

        public void update(int index, int val) {
            int value = val - originalNums[index];
            originalNums[index] = val;
            while (index < nums.length) {
                nums[index++] += value;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return nums[right];
            }
            return nums[right] - nums[left - 1];
        }
    }


}
