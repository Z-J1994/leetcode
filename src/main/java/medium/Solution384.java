package medium;

import java.util.Arrays;

public class Solution384 {
    private int[] original;
    private int[] shuffle;

    public Solution384(int[] nums) {
        shuffle = nums;
        original = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        for (int i = shuffle.length; i > 1; i--) {
            int random = (int) (Math.random() * i);
            int t = shuffle[i - 1];
            shuffle[i - 1] = shuffle[random];
            shuffle[random] = t;
        }
        return shuffle;
    }
}
