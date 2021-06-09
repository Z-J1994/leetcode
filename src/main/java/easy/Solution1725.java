package main.java.easy;

/**
 * @author zhangjun
 * @version 2021/6/9
 */
public class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int maxLen = 0;
        for (int[] r : rectangles) {
            int min = Math.min(r[0], r[1]);
            if (min > maxLen) {
                count = 1;
                maxLen = min;
            } else if (min == maxLen) {
                ++count;
            }
        }
        return count;
    }
}
