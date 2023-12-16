package medium;

import utils.Parser;

import java.util.PriorityQueue;

/**
 * @author zhangjun
 * @since 2023/12/11 13:24
 */
public class Solution1631 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        heap.add(new int[]{0, heights[0][0], 0, 0});
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int x = poll[2];
            int y = poll[3];
            visited[x][y] = true;
            if (n == poll[2] + 1 && m == poll[3] + 1) {
                return poll[0];
            }
            for (int[] direction : directions) {
                x = poll[2] + direction[0];
                y = poll[3] + direction[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
                    continue;
                }
                int difference = Math.max(Math.abs(heights[x][y] - poll[1]),poll[0]);
                heap.add(new int[]{difference, heights[x][y], x, y});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1631 s = new Solution1631();
        System.out.println(s.minimumEffortPath(Parser.stringToIntMatrix("[[1,2,2],[3,8,2],[5,3,5]]", 3, 3)) == 2);
        System.out.println(s.minimumEffortPath(Parser.stringToIntMatrix("[[1,2,3],[3,8,4],[5,3,5]]", 3, 3)) == 1);
        System.out.println(s.minimumEffortPath(Parser.stringToIntMatrix("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]", 5, 5)) == 0);
    }
}
