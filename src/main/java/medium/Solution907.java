package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2023/11/27 13:34
 */
public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[][] mins = new int[arr.length + 1][2];
        for (int i = 0, s = 0, p = 0, pi; i < arr.length; i++) {
            int k = arr[i];
            s += k;
            pi = i;
            while (mins[p][0] >= k) {
                s -= (mins[p][0] - k) * (pi - mins[p][1]);
                pi = mins[p][1];
                p--;
            }
            mins[++p][0] = k;
            mins[p][1] = pi;
            sum += s;
        }
        return (int) (sum % (1000000007));
    }

    public static void main(String[] args) {
        Solution907 solution = new Solution907();
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[4]")) == 4);
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[4,3]")) == 10);
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[4,3,2]")) == 16);
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[4,3,2,1]")) == 20);
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[3,1,2,4]")) == 17);
        System.out.println(solution.sumSubarrayMins(Parser.StringToIntArray("[11,81,94,43,3]")) == 444);
    }
}
