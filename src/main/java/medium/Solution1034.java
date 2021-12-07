package medium;

public class Solution1034 {
    int [][] marked;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int original = grid[row][col];
        marked = new int[grid.length][grid[0].length];
        dfs(grid, row, col, original);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (marked[i][j] == -1) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int column, int original) {
        if(marked[row][column] != 0){
            return;
        }
        marked[row][column] = 1;
        if (row == 0 || grid[row - 1][column] != original) {
            marked[row][column] = -1;
        } else {
            dfs(grid, row - 1, column, original);
        }

        if (row == grid.length - 1 || grid[row + 1][column] != original) {
            marked[row][column] = -1;
        } else {
            dfs(grid, row + 1, column, original);
        }

        if (column == 0 || grid[row][column - 1] != original) {
            marked[row][column] = -1;
        } else {
            dfs(grid, row, column - 1, original);
        }

        if (column == grid[0].length - 1 || grid[row][column + 1] != original) {
            marked[row][column] = -1;
        } else {
            dfs(grid, row, column + 1, original);
        }
    }
}
