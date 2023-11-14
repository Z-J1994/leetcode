package medium;

import utils.Parser;

import java.util.*;

public class Solution1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = new List[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge);
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(edge);
        }
        int minIndex = 0;
        int min = -1 >>> 1;

        for (int i = 0; i < n; i++) {
            if (graph[i] != null) {
                Set<Integer> cities = new HashSet<>();
                bfs(i, graph, distanceThreshold, new boolean[n],cities);
                if (cities.size() <= min) {
                    min = cities.size();
                    minIndex = i;
                }
            } else {
                min = 0;
                minIndex = i;
            }

        }
        return minIndex;
    }


    private void bfs(int index, List<int[]>[] graph, int distanceThreshold, boolean[] visited, Set<Integer> cities) {
        cities.add(index);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{index, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(visited[poll[0]]){
                continue;
            }
            visited[poll[0]] = true;
            for (int[] edge : graph[poll[0]]) {
                int t = edge[0] == poll[0] ? edge[1] : edge[0];
                if (!visited[t] && poll[1] + edge[2] <= distanceThreshold) {
                    queue.offer(new int[]{t, poll[1] + edge[2]});
                    cities.add(t);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1334 s = new Solution1334();
        System.out.println(s.findTheCity(4, Parser.stringToIntMatrix("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]", 4, 3), 4) == 3);
        System.out.println(s.findTheCity(5, Parser.stringToIntMatrix("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]", 6, 3), 2) == 0);
        System.out.println(s.findTheCity(6, Parser.stringToIntMatrix("[[0,1,10],[0,2,1],[2,3,1],[1,3,1],[1,4,1],[4,5,10]]", 6, 3), 20) == 5);
    }
}
