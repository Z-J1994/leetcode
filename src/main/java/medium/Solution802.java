package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/8/5
 */
public class Solution802 {
    private boolean[] onStack;
    private boolean[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        onStack = new boolean[n];
        visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
            if (!onStack[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int start) {
        onStack[start] = true;
        visited[start] = true;

        for (int v : graph[start]) {
            if (!visited[v]) {
                if(dfs(graph, v)){
                    return true;
                }
            } else if (onStack[v]) {
                return true;
            }
        }

        onStack[start] = false;
        return false;
    }
}
