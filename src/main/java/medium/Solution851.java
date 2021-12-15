package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[quiet.length];
        int[] answer = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            graph[i] = new ArrayList<>();
            answer[i] = -1;
        }
        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
        }

        for (int i = 0; i < quiet.length; i++) {
            dfs(graph, i, answer, quiet);
        }
        return answer;
    }

    private int dfs(List<Integer>[] graph, int x, int[] answer, int[] quiet) {
        if (answer[x] != -1) {
            return answer[x];
        }
        int min = x;
        for (Integer i : graph[x]) {
            int result = dfs(graph, i, answer, quiet);
            if (quiet[result] < quiet[min]) {
                min = result;
            }
        }
        answer[x] = min;
        return min;
    }


}
