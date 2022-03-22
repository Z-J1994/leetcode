package medium;

import java.util.*;

public class Solution2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int length = patience.length;
        List<Integer>[] graph = new List[length];
        for(int i = 0;i < length;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int max = 0;
        boolean[] visited = new boolean[length];
        visited[0] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int size = 1;
        int distance = 1;
        while (!queue.isEmpty()) {
            int s = queue.poll();
            for (int e : graph[s]) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.offer(e);

                    int d = distance * 2;
                    int t = (d / patience[e]) * patience[e];
                    if (t == d) {
                        if ((t = (d * 2 - patience[e])) > max) {
                            max = t;
                        }
                    } else {
                        if ((t = t + d) > max) {
                            max = t;
                        }
                    }
                }
            }
            if (--size == 0) {
                size = queue.size();
                distance++;
            }
        }
        return max + 1;
    }


    public static void main(String[] args) {
        Solution2039 s = new Solution2039();
        System.out.println(s.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1}) == 8);
        System.out.println(s.networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10}) == 3);
        System.out.println(s.networkBecomesIdle(new int[][]{{5, 7}, {15, 18}, {12, 6}, {5, 1}, {11, 17}, {3, 9}, {6, 11}, {14, 7}, {19, 13}, {13, 3}, {4, 12}, {9, 15}, {2, 10}, {18, 4}, {5, 14}, {17, 5}, {16, 2}, {7, 1}, {0, 16}, {10, 19}, {1, 8}}, new int[]{0, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1}));
    }
}
