package easy;

/**
 * @author zhangjun
 * @since 2024/4/18 13:16
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int perimeter = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    continue;
                }
                for(int [] direction : directions){
                    int ni = i + direction[0];
                    int nj = j + direction[1];
                    if(ni < 0 || ni == grid.length || nj < 0 || nj == grid[0].length || grid[ni][nj] == 0){
                        ++perimeter;
                    }
                }
            }
        }
        return perimeter;
    }
}
