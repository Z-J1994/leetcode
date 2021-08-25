package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 12:35
 */
public class Solution797 {
    int n;
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length - 1;
        result = new ArrayList<>();
        dfs(0,graph,new ArrayList<>(),0);
        return result;
    }
    private void dfs(int to,int[][] graph,List<Integer> list,int index){
        list.add(to);
        if(to == n){
            result.add(new ArrayList<>(list));
        }
        int []adj = graph[to];
        for(int t : adj){
            dfs(t,graph,list,index + 1);
        }
        list.remove(index);
    }
}
