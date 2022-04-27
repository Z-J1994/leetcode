package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution417 {
    int[][] mark;

    /**
     * mark[row][column] & mask1) != 0 表示深度优先搜索已经访问过,上面和左边递归时mask1 = 1,下面和右边递归时mask1 = 2
     * mark[row][column] & 4) == 1 表示可以到上面和左边 mark[row][column] & 8) == 1 表示可以到右边和下边
     * mark[row][column] >= 12) 表示可以到四边
     *
     * @param heights 参数
     * @return 结果
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        mark = new int[m][n];

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i,1,4);
        }
        for (int i = 1; i < m; i++) {
            dfs(heights, i, 0,1,4);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, m - 1, i,2,8);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1,2,8);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j] >= 12) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int column,int mask1,int mask2) {
        if ((mark[row][column] & mask1) != 0) {
            return;
        }
        mark[row][column] |= mask1;
        if (row > 0 && heights[row][column] <= heights[row - 1][column]) {
            dfs(heights, row - 1, column,mask1,mask2);
        }
        if (column > 0 && heights[row][column] <= heights[row][column - 1]) {
            dfs(heights, row, column - 1,mask1,mask2);
        }
        if (row + 1 < heights.length && heights[row][column] <= heights[row + 1][column]) {
            dfs(heights, row + 1, column,mask1,mask2);
        }
        if (column + 1 < heights[0].length && heights[row][column] <= heights[row][column + 1]) {
            dfs(heights, row, column + 1,mask1,mask2);
        }
        mark[row][column] |= mask2;
    }
}
