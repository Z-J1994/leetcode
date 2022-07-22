package hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangjun
 * @since 2022/7/22 12:58
 */
public class Solution757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int c = -1;
        int p = c - 1;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] > c) {
                count += 2;
                c = interval[1];
                p = c - 1;
            } else if (interval[0] == c || interval[0] > p) {
                count += 1;
                p = c;
                c = interval[1];
            }
        }
        return count;
    }
}
