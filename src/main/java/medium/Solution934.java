package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @version 2022/10/25
 */
public class Solution934 {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        int[] deque = new int[grid.length * grid.length];
        boolean[] visited = new boolean[grid.length * grid.length];
        boolean proceed = true;
        int index = 0;
        for (int i = 0; i < grid.length && proceed; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    index = dfs(grid, i, j, visited, deque,index);
                    proceed = false;
                    break;
                }
            }
        }
        return bfs(grid, deque,index);
    }

    private int dfs(int[][] grid, int x, int y, boolean[] visited, int[] deque, int index) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] != 1 || visited[x * grid.length + y]) {
            return index;
        }
        visited[x * grid.length + y] = true;
        grid[x][y] = -1;
        deque[index++] = x * grid.length + y;
        for (int[] direction : directions) {
            index = dfs(grid, x + direction[0], y + direction[1], visited, deque, index);
        }
        return index;
    }

    private int bfs(int[][] grid, int[] deque,int index) {
        boolean[] visited = new boolean[grid.length * grid.length];
        int size = index;
        int distance = 0;
        int t, x, y, x1, y1;
        int i = 0;
        while (size > 0) {

            x = deque[i] / grid.length;
            y = deque[i++] % grid.length;

            for (int[] direction : directions) {
                x1 = x + direction[0];
                y1 = y + direction[1];
                t = x1 * grid.length + y1;
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid.length) {
                    if (grid[x1][y1] == 1) {
                        return distance;
                    }
                    if (grid[x1][y1] == 0 && !visited[t]) {
                        visited[t] = true;
                        deque[index++] = t;
                    }
                }
            }
            if (--size == 0) {
                distance++;
                size = index - i;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Solution934 solution934 = new Solution934();
        System.out.println(solution934.shortestBridge(Parser.stringToIntMatrix("[[0,1],[1,0]]", 2, 2)) == 1);
        System.out.println(solution934.shortestBridge(Parser.stringToIntMatrix("[[0,1,0],[0,0,0],[0,0,1]]", 3, 3)) == 2);
        System.out.println(solution934.shortestBridge(Parser.stringToIntMatrix("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]", 5, 5)) == 1);
        System.out.println(solution934.shortestBridge(Parser.stringToIntMatrix("[[0,1,0,0,0],[0,1,0,1,1],[0,0,0,0,1],[0,0,0,0,0],[0,0,0,0,0]]", 5, 5)) == 1);
    }
}
