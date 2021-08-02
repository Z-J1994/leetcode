package medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author zhangjun
 * @version 2021/8/2
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph g = new Graph(n);
        for(int[] time : times){
            g.add(time);
        }
        g.dijkstra(k);
        return g.getMaxDistance();
    }
    private static class DirectionWeightEdge implements Comparable<DirectionWeightEdge> {
        private int end;
        private int weight;

        public DirectionWeightEdge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(DirectionWeightEdge o) {
            return weight - o.weight;
        }
    }

    private static class Graph {
        private final ArrayList<DirectionWeightEdge>[] adjacent;
        private final int[] distance;
        private final boolean[] marked;

        private Graph(int n) {
            marked = new boolean[n + 1];
            distance = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                distance[i] = 0x7FFFFFFF;
            }
            adjacent = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adjacent[i] = new ArrayList<>();
            }
        }

        private void add(int[] edge) {
            adjacent[edge[0]].add(new DirectionWeightEdge(edge[1], edge[2]));
        }

        private void dijkstra(int start) {
            PriorityQueue<DirectionWeightEdge> queue = new PriorityQueue<>();
            queue.offer(new DirectionWeightEdge(start, 0));
            while (!queue.isEmpty()) {
                DirectionWeightEdge current = queue.poll();
                int d = current.weight;
                if(marked[current.end]){
                    continue;
                }
                marked[current.end] = true;
                if (distance[current.end] > d) {
                    distance[current.end] = d;
                }
                for (DirectionWeightEdge e : adjacent[current.end]) {
                    if (!marked[e.end]) {
                        e.weight += d;
                        queue.offer(e);
                    }
                }
            }
        }
        private int getMaxDistance() {
            int max = 0;
            for (int i = 1, l = distance.length; i < l; i++) {
                if (distance[i] > max) {
                    max = distance[i];
                }
                if (!marked[i]) {
                    return -1;
                }
            }
            return max;
        }
    }
}
