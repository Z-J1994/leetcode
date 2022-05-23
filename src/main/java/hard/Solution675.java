package hard;

import java.util.*;

/**
 * @author zhangjun
 * @since 2022/5/23 12:55
 */
public class Solution675 {
    private final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        int[][] map = new int[n][m];
        int length = n * m;
        int[][] elements = new int[length][3];
        Iterator<List<Integer>> iterator = forest.iterator();
        for (int i = 0, index = 0; i < n; i++) {
            Iterator<Integer> listIterator = iterator.next().iterator();
            for (int j = 0; j < m; j++) {
                map[i][j] = listIterator.next();
                elements[index][0] = map[i][j];
                elements[index][1] = i;
                elements[index++][2] = j;
            }
        }
        Arrays.sort(elements, Comparator.comparingInt(a -> a[0]));
        int index = -1;
        while (++index < length && elements[index][0] == 0 || elements[index][0] == 1) ;
        int step = 0;
        int startX = 0, startY = 0;
        while (++index < length) {
            int[] element = elements[index++];
            int bfs = bfs(map, startX, startY, element[1], element[2]);
            if (bfs == -1) {
                return -1;
            }
            step += bfs;
            startX = element[1];
            startY = element[2];
        }
        return step;
    }

    private int bfs(int[][] map, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        boolean[][] visited = new boolean[map.length][map[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        int step = 0;
        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] direction : directions) {
                int x = poll[0] + direction[0];
                int y = poll[1] + direction[1];
                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != 0 && !visited[x][y]) {
                    if (x == targetX && y == targetY) {
                        return step + 1;
                    }
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            if (--size == 0) {
                step++;
                size = queue.size();
            }
        }
        return -1;
    }
}
