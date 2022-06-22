package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/6/22 12:43
 */
public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        k = k % (row * column);
        List<List<Integer>> result = new ArrayList<>(row);
        for(int i = 0;i < row;i++){
            result.add(new ArrayList<>());
        }

        for(int i = 0,r = (row - (k + column - 1)/ column) % row,c = (k % column) == 0 ? 0 : column - (k % column);i < row;i++){
            for(int j = 0;j < column;j++){
                result.get(i).add(grid[r][c]);
                r = (r + (++c / column)) % row;
                c = c % column;
            }
        }
        return result;
    }
}
