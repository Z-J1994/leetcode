package easy;

public class Solution892 {
    public int surfaceArea(int[][] grid) {
        int area = 0;
        if(grid[0][0] > 0){
            area = grid[0][0] * 4 + 2;
        }
        //第一行
        for(int i = 1;i < grid.length;i++){
            if(grid[0][i] > 0){
                area += (grid[0][i] * 4 + 2) - (2 * Math.min(grid[0][i - 1],grid[0][i]));
            }
        }
        for(int i = 1;i < grid.length;i++){
            if(grid[i][0] > 0){
                area += (grid[i][0] * 4 + 2) - (2 * Math.min(grid[i - 1][0],grid[i][0]));
            }
            for(int j = 1;j < grid.length;j++){
                if(grid[i][j] > 0){
                    area += (grid[i][j] * 4 + 2) - (2 * (Math.min(grid[i - 1][j],grid[i][j]) + Math.min(grid[i][j - 1],grid[i][j])));
                }
            }
        }
        return area;
    }
}
