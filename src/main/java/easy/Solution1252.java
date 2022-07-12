package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  14:47
 */
public class Solution1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] am = new int[m];
        int[] an = new int[n];
        for (int[] i : indices) {
            am[i[0]] += 1;
            an[i[1]] += 1;
        }
        int[] element = new int[2];
        for (int i = 0; i < m; i++) {
            element[0] += am[i] & 1;
            element[1] += 1 - (am[i] & 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += element[an[i] & 1];
        }
        return count;
    }
}
