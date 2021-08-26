package medium;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/24 19:24
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<DirectionWeightEdge>[] graph = new ArrayList[n];
        int [] distance = new int[n];
        for(int i = 0;i < n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for (int[] flight : flights) {
            int from = flight[0];
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(new DirectionWeightEdge(flight[1], flight[2]));
        }

        LinkedList<DirectionWeightEdge> queue = new LinkedList<>();
        if(graph[src] == null){
            return -1;
        }
        for (DirectionWeightEdge edge : graph[src]) {
            distance[edge.to] = edge.weight;
            queue.offer(new DirectionWeightEdge(edge.to, edge.weight));
        }
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                DirectionWeightEdge e = queue.poll();
                if (graph[e.to] != null) {
                    for (DirectionWeightEdge edge : graph[e.to]) {
                        if (distance[edge.to] > edge.weight + e.weight) {
                            distance[edge.to] = edge.weight + e.weight;
                            queue.offer(new DirectionWeightEdge(edge.to, edge.weight + e.weight));
                        }
                    }
                }
            }
            k--;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    private static class DirectionWeightEdge {
        private int to;
        private int weight;

        public DirectionWeightEdge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
