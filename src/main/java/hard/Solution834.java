package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @version 2020/10/06  19:17
 */
public class Solution834 {
    ArrayList<Integer> [] adj;
    int [] result;
    int [] count;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        count = new int[N];
        result = new int[N];
        adj = (ArrayList<Integer> [])new ArrayList[N];
        for(int i = 0;i < N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0;i < edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        DFS1(0,-1);
        DFS2(0,-1);

        return result;
    }

    private void DFS1(int vertex,int father){

        for(int w:adj[vertex]){
            if(w != father){
                DFS1(w,vertex);
                count[vertex] += count[w];
                result[vertex] += result[w] + count[w];
            }
        }
        count[vertex]++;
    }

    private void DFS2(int vertex,int father){
        for(int w:adj[vertex]){
            if(w != father){
                result[w] = result[vertex] - count[w] + count.length - count[w];
                DFS2(w,vertex);
            }
        }
    }

}
