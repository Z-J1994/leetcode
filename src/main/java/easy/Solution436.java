package easy;

/**
 *
 * @author zhangjun
 * @version 2020/10/02  16:27
 */
public class Solution436 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int x = 0;x < grid.length;x++){
            for(int y = 0;y < grid[x].length;y++){
                if(grid[x][y] == 1){
                    perimeter += 4;
                    if (y > 0 && grid[x][y - 1] == 1){
                        perimeter -= 2;
                    }
                    if(x > 0 && grid[x - 1][y] == 1){
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

}
