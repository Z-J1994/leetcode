package medium;

public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int [] rowMax = new int [length];
        int [] columnMax = new int [length];
        for(int i = 0;i < length;i++){
            int c = 0;
            for(int j = 0;j < length;j++){
                if(grid[i][j] > c){
                    c = grid[i][j];
                }
                if(grid[i][j] > rowMax[j]){
                    rowMax[j] = grid[i][j];
                }
            }
            columnMax[i] = c;
        }
        int sum = 0;
        for(int i = 0;i < length;i++){
            int c = columnMax[i];
            for(int j = 0;j < length;j++){
                sum += Math.min(rowMax[j],c) - grid[i][j];
            }
        }
        return sum;
    }
}
