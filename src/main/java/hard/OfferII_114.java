package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/5/31 12:50
 */
public class OfferII_114 {
    public String alienOrder(String[] words) {
        List<Integer>[] graph = new List[26];
        for (String s : words) {
            for (int i = 0, l = s.length(), t; i < l; i++) {
                t = s.charAt(i) - 'a';
                if (graph[t] == null) {
                    graph[t] = new ArrayList<>();
                }
            }
        }
        for (int i = 1, j, l; i < words.length; i++) {
            j = 0;
            l = Math.min(words[i - 1].length(), words[i].length());
            while (j < l && words[i].charAt(j) == words[i - 1].charAt(j)) {
                j++;
            }
            if (l != j) {
                int start = words[i - 1].charAt(j) - 'a';
                int end = words[i].charAt(j) - 'a';
                if (start != end) {
                    graph[start].add(end);
                }
            }else if(words[i - 1].length() > words[i].length()){
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[26];
        for (int i = 0; i < 26; i++) {
            if (graph[i] != null && visited[i] == 0) {
                dfs(visited, graph, i, sb);
            }
        }
        return cycle ? "" : sb.reverse().toString();
    }

    private boolean cycle = false;

    private void dfs(int[] visited, List<Integer>[] graph, int start, StringBuilder sb) {
        visited[start] = 1;
        for (int e : graph[start]) {
            if (!cycle) {
                if (visited[e] == 0) {
                    dfs(visited, graph, e, sb);
                } else if (visited[e] == 1) {
                    cycle = true;
                    return;
                }
            }
        }
        visited[start] = 2;
        sb.append((char) (start + 'a'));
    }

    public static void main(String[] args) {
        OfferII_114 s = new OfferII_114();
//        System.out.println(s.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}).equals("wertf"));
//        System.out.println(s.alienOrder(new String[]{"z", "x"}).equals("zx"));
//        System.out.println(s.alienOrder(new String[]{"z", "x", "z"}).equals(""));
//        System.out.println(s.alienOrder(new String[]{"z", "z"}).equals("z"));
        System.out.println(s.alienOrder(new String[]{"abc","ab"}).equals(""));
    }
}
