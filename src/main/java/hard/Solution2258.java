package hard;

import utils.Parser;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2258 {

    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        bfs(grid, new ArrayDeque<>());
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1000000000;
                } else if (grid[i][j] == 2) {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] -= 10;
                }
            }
        }

        return bfs1(grid, new PriorityQueue<>(Comparator.comparingInt(e -> -grid[e.x][e.y])));
    }

    private void bfs(int[][] grid, Queue<Pair> queue) {
        int step = 10;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = step;
                    queue.add(new Pair(i, j));
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int s = queue.size();
        while (!queue.isEmpty()) {
            Pair t = queue.poll();
            for (int[] direction : directions) {
                int nx = t.x + direction[0];
                int ny = t.y + direction[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    grid[nx][ny] = step + 1;
                }
            }
            if (--s == 0) {
                s = queue.size();
                step++;
            }
        }
    }

    private int bfs1(int[][] grid, Queue<Pair> queue) {
        queue.add(new Pair(0, 0, 0));
        grid[0][0] -= 1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Pair t = queue.poll();
            int step = t.step + 1;
            for (int[] direction : directions) {
                int nx = t.x + direction[0];
                int ny = t.y + direction[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] > 0 && grid[nx][ny] >= step && !visited[nx][ny]) {
                    int min = Math.min(grid[nx][ny] - step - 1, grid[t.x][t.y]);
                    if (nx == grid.length - 1 && ny == grid[0].length - 1) {
                        int k = Math.min(grid[nx][ny] - step, grid[t.x][t.y]);
                        return k > 900000000 ? 1000000000 : k;
                    }
                    grid[nx][ny] = min;
                    queue.add(new Pair(nx, ny, step));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    private static class Pair {
        private final int x;
        private final int y;
        private int step;

        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int getStep() {
            return step;
        }
    }

    public static void main(String[] args) {
        Solution2258 s = new Solution2258();
//        System.out.println(s.maximumMinutes(Parser.stringToIntMatrix("[[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]", 5, 7)));
//        System.out.println(s.maximumMinutes(Parser.stringToIntMatrix("[[0,2,0,0,0],[0,2,0,2,0],[0,2,1,2,0],[0,2,2,2,0],[0,2,2,2,0],[0,0,0,0,0]]", 6, 5)));
        System.out.println(s.maximumMinutes(Parser.stringToIntMatrix("[[0,0,0,0,0,0],[0,2,2,2,2,0],[0,0,0,1,2,0],[0,2,2,2,2,0],[0,0,0,0,0,0]]", 5, 6)));
    }
}
