package easy;

public class Solution883 {
    public int projectionArea(int[][] grid) {
        int area = 0;
        for(int i = 0,maxRow,maxColumn;i < grid.length;i++){
            maxRow = 0;
            maxColumn = 0;
            for(int j = 0;j < grid.length;j++){
                if(grid[i][j] > 0){
                    area++;
                    maxRow = Math.max(grid[i][j],maxRow);
                }
                maxColumn = Math.max(grid[j][i],maxColumn);
            }
            area += maxRow + maxColumn;
        }
        return area;
    }
}
