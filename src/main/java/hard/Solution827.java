package hard;

public class Solution827 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid) {
        int[] size = new int[grid.length * grid.length / 2 + 3];
        int t = 2;
        int max = 1;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    size[t] = dfs(grid, x, y, t);
                    if (size[t] > 0) {
                        max = Math.max(size[t], max);
                        t++;
                    }
                }
            }
        }
        int[] set = new int[4];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 0) {
                    int index = 0;
                    int s = 1;
                    for (int[] d : directions) {
                        int x2 = x + d[0];
                        int y2 = y + d[1];
                        if (x2 < 0 || x2 >= grid.length || y2 < 0 || y2 >= grid[0].length || contains(set,index,grid[x2][y2])) {
                            continue;
                        }
                        s += size[grid[x2][y2]];
                        set[index++] = grid[x2][y2];
                    }
                    max = Math.max(max, s);
                }
            }
        }
        return max;
    }

    private boolean contains(int[] set, int length, int target) {
        while (--length >= 0) {
            if (set[length] == target) {
                return true;
            }
        }
        return false;
    }

    private int dfs(int[][] grid, int x, int y, int t) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = t;
        int c = 1;
        for (int[] direction : directions) {
            c += dfs(grid, x + direction[0], y + direction[1], t);
        }
        return c;
    }
}
