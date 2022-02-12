package medium;

/**
 * @author zhangjun
 * @version 2022/2/12
 */
public class Solution1020 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < n;i++){
            dfs(grid,0,i);
            dfs(grid,m - 1,i);
        }
        for(int i = 0;i < m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n - 1);
        }
        int count = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid,int x,int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0){
            return;
        }
        grid[x][y] = 0;
        dfs(grid,x + 1,y);
        dfs(grid,x - 1,y);
        dfs(grid,x,y + 1);
        dfs(grid,x,y - 1);
    }
}
