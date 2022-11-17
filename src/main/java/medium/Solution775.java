package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @version 2022/11/16
 */
public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int t = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                t++;
            }
        }
        return t == reversePair(nums);
    }

    private int reversePair(int[] elements) {
        return dfs(elements,new int[elements.length],0,elements.length - 1);
    }

    private int dfs(int[] elements, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >>> 1;
        int result = dfs(elements, temp, start, mid) + dfs(elements, temp, mid + 1, end);
        System.arraycopy(elements, start, temp, start, end - start + 1);
        int i = start, j = mid + 1;
        while (start <= mid && j <= end) {
            if (temp[start] > temp[j]) {
                result += mid - start + 1;
                elements[i++] = temp[j++];
            } else {
                elements[i++] = temp[start++];
            }
        }
        while (start <= mid) {
            elements[i++] = temp[start++];
        }
        while (j <= end) {
            elements[i++] = temp[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution775 s = new Solution775();
        System.out.println(s.isIdealPermutation(Parser.StringToIntArray("[1,0,2]")));
    }
}
