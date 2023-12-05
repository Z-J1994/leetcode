package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution2477 {
    private long sum;

    private int seats;

    private List<Integer>[] graph;

    public long minimumFuelCost(int[][] roads, int seats) {
        sum = 0;
        graph = new List[roads.length + 1];
        this.seats = seats;
        for(int [] road : roads){
            if(graph[road[0]] == null){
                graph[road[0]] = new ArrayList<>();
            }
            if(graph[road[1]] == null){
                graph[road[1]] = new ArrayList<>();
            }
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        dfs(0,-1);
        return sum;
    }

    private long dfs(int index,int from){
        if(graph[index] == null){
            return 0L;
        }
        long t = 0;
        for(int p : graph[index]){
            if(p != from){
                long k = dfs(p,index);
                sum += (k + seats - 1) / seats;
                t += k;
            }
        }

        return t + 1;
    }
}
