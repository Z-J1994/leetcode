package easy;

/**
 * @author zhangjun
 * @version 2021/7/23
 */
public class Solution1893 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] map = new int[51];
        int[] zero = new int[51];
        for (int i = 0, l = ranges.length; i < l; i++) {
            if (ranges[i][0] == ranges[i][1]) {
                zero[ranges[i][0]] = 1;
            } else {
                map[ranges[i][0]] += i + 1;
                map[ranges[i][1]] += -(i + 1);
            }
        }

        int t = 0;
        for (int i = 1; i < left; i++) {
            t += map[i];
        }
        for (int i = left; i <= right; i++) {
            if (t == 0 && map[i] == 0 && zero[i] == 0) {
                return false;
            }
            t += map[i];
        }
        return true;
    }
}
