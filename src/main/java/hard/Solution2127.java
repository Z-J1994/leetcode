package hard;

import utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class Solution2127 {

    public int maximumInvitations(int[] favorite) {
        int[][] steps = new int[favorite.length][2];
        int max = 2;
        List<Integer> mates = new ArrayList<>();
        List<Integer>[] reversedGraph = new List[favorite.length];
        for (int i = 0, j, step, k; i < favorite.length; i++) {
            if (reversedGraph[favorite[i]] == null) {
                reversedGraph[favorite[i]] = new ArrayList<>();
            }
            reversedGraph[favorite[i]].add(i);

            for (j = i, step = 1; steps[j][0] == 0; j = favorite[j]) {
                steps[j][0] = step++;
                steps[j][1] = i;
            }
            if(steps[j][1] == i){
                k = step - steps[j][0];
                if (k == 2 && j == favorite[favorite[j]]) {
                    mates.add(j);
                } else if (k > max) {
                    max = k;
                }
            }
        }

        boolean[] visited = new boolean[favorite.length];
        int sum = 0;
        for (int p : mates) {
            visited[favorite[p]] = true;
            sum += dfs(reversedGraph, p, visited, 1) + dfs(reversedGraph, favorite[p], visited, 1);
        }
        return Math.max(sum, max);

    }

    private int dfs(List<Integer>[] reversedGraph, int index, boolean[] visited, int step) {
        if (reversedGraph[index] == null) {
            return step;
        }
        int max = 0;
        visited[index] = true;
        for (int i : reversedGraph[index]) {
            if (!visited[i]) {
                max = Math.max(max, dfs(reversedGraph, i, visited, step));
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Solution2127 s = new Solution2127();
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[1,0,0,2,1,4,7,8,9,6,7,10,8]")) == 6);
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[1,0,3,2,5,6,7,4,9,8,11,10,11,12,10]")) == 11);
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[3,4,7,4,6,2,4,3,2]")) == 6);
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[6,4,4,5,0,3,3]")) == 6);
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[2,3,0,0,1,3]")) == 5);
        System.out.println(s.maximumInvitations(Parser.StringToIntArray("[23,14,17,5,19,2,0,18,15,12,2,8,21,3,3,1,6,5,11,17,3,7,14,13]")) == 3);
    }
}
