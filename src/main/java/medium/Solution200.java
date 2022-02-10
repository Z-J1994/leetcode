package medium;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns;j++){
                if(grid[i][j] == '1'){
                    ++count;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char [][] grid,int x,int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid,x + 1,y);
        dfs(grid,x - 1,y);
        dfs(grid,x,y + 1);
        dfs(grid,x,y - 1);
    }
}
