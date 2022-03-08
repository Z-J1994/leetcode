package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2022/3/8
 */
public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] map = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        int c = 0;
        int i = 0;
        while (i < length && s.charAt(i++) == '*');
        int pi = 0;
        for (; i < length; i++) {
            if (s.charAt(i) == '*') {
                c++;
            } else {
                map[i] = c;
                pi = i;
            }
            left[i] = pi;
        }

        pi = length - 1;
        while (--i >= 0) {
            if (s.charAt(i) != '*') {
                pi = i;
            }
            right[i] = pi;
        }
        length = queries.length;
        int[] result = new int[length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = left[query[1]] < right[query[0]] ? 0 : map[left[query[1]]] - map[right[query[0]]];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2055 s = new Solution2055();
        System.out.println(Arrays.toString(s.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
        System.out.println(Arrays.toString(s.platesBetweenCandles("|*|*", new int[][]{{3, 3}})));
    }
}
