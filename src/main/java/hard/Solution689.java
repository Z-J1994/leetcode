package hard;

import java.util.Arrays;

public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] differences = new int[nums.length + 1];
        for (int i = 1; i < differences.length; i++) {
            differences[i] = differences[i - 1] + nums[i - 1];
        }
        for (int i = differences.length - 1; i >= k; i--) {
            differences[i] -= differences[i - k];
        }

        int[] stack = new int[differences.length];
        for (int i = 1; i < differences.length; i++) {
            if (differences[i] > differences[stack[i - 1]]) {
                stack[i] = i;
            } else {
                stack[i] = stack[i - 1];
            }
        }

        int[] stack2 = new int[differences.length];
        stack2[k] = k;
        for (int i = k + 1; i < stack.length; i++) {
            if (differences[i] + differences[stack[i - k]] > differences[stack2[i - 1]] + differences[stack[stack2[i - 1] - k]]) {
                stack2[i] = i;
            } else {
                stack2[i] = stack2[i - 1];
            }
        }
        int a = 0, b = 0, c = 0;
        int max = 0;
        for (int i = 2 * k, t; i < differences.length; i++) {
            int l = stack[stack2[i - k] - k];
            if ((t = differences[i] + differences[stack2[i - k]] + differences[l]) > max) {
                max = t;
                a = l;
                b = stack2[i - k];
                c = i;
            }
        }
        return new int[]{a - k, b - k, c - k};
    }


    public static void main(String[] args) {
        Solution689 s = new Solution689();
//        int [] a = {1,2,1,2,6,7,5,1};
        int[] a = {1, 2, 1, 2, 1, 2, 1, 2, 1};

        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(a, 2)));
    }
}
