package medium;

import utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class Solution1466 {

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for(int [] edge : connections){
            if(graph[edge[0]] == null){
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            if(graph[edge[1]] == null){
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(-edge[0]);

        }
        return dfs(0,0,graph);
    }

    private int dfs(int from,int index,List<Integer>[] graph){
        int s = 0;
        for(int to : graph[index]){
            if(from != Math.abs(to)){
                if(to > 0){
                    s++;
                }
                s += dfs(index,Math.abs(to),graph);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution1466 s = new Solution1466();
        System.out.println(s.minReorder(6, Parser.stringToIntMatrix("[[0,1],[1,3],[2,3],[4,0],[4,5]]", 5, 2)));
    }
}
