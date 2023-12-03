package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2023/12/1 13:30
 */
public class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[][] map = new int[arr.length + 1][2];
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[mat[i][j]][0] = i;
                map[mat[i][j]][1] = j;
            }
        }
        int[] row = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < arr.length; i++) {
            int[] point = map[arr[i]];
            boolean r = ++row[point[0]] == m;
            boolean c = ++column[point[1]] == n;
            if (r || c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2661 s = new Solution2661();
        System.out.println(s.firstCompleteIndex(Parser.StringToIntArray("[1,3,4,2]"), Parser.stringToIntMatrix("[[1,4],[2,3]]",2,2)) == 2);
        System.out.println(s.firstCompleteIndex(Parser.StringToIntArray("[2,8,7,4,1,3,5,6,9]"), Parser.stringToIntMatrix("[[3,2,5],[1,4,6],[8,7,9]]",3,3)) == 3);
    }
}
