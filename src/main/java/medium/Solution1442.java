package medium;

/**
 * @author zhangjun
 * @version 2021/5/18
 */
public class Solution1442 {
    public int countTriplets(int[] arr) {
        int length = arr.length + 1;
        int[] dp = new int[length];
        for (int i = 1, t = 0; i < length; i++) {
            t ^= arr[i - 1];
            dp[i] = t;
        }
        int count = 0;
        for (int i = 1; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                if (dp[i - 1] == dp[k]) {
                    count += k - i;
                }
            }

        }
        return count;
    }
}
