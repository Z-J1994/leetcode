package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/9/17
 */
public class Solution212 {
    List<String> result = new ArrayList<>();
    int rowLimit;
    int columnLimit;
    boolean matched;
    public List<String> findWords(char[][] board, String[] words) {
        rowLimit = board.length;
        columnLimit = board[0].length;
        boolean [][] visited = new boolean [rowLimit][columnLimit];

        ArrayList<Pair> [] graph = new ArrayList[26];
        for(int i = 0;i < rowLimit;i++){
            for(int j = 0;j < columnLimit;j++){
                char c = board[i][j];
                if(graph[c - 97] == null){
                    graph[c - 97] = new ArrayList<>();
                }
                graph[c - 97].add(new Pair(i,j));
            }
        }

        for(String s : words){
            ArrayList<Pair> pairs = graph[s.charAt(0) - 97];
            if(pairs != null){
                for(Pair p : pairs){
                    int size = result.size();
                    matched = false;
                    dfs(s,0,p.x,p.y,visited,board);
                    if(result.size() > size){
                        break;
                    }
                }
            }
        }
        return result;
    }

    private void dfs(String s,int index,int row,int column,boolean [][] visited,char[][] board){
        if(matched || row < 0 || row >= rowLimit || column < 0 || column >= columnLimit){
            return;
        }
        if(visited[row][column]){
            return;
        }

        if(s.charAt(index++) != board[row][column]){
            return;
        }

        if(index == s.length()){
            result.add(s);
            matched = true;
            return;
        }

        visited[row][column] = true;
        dfs(s,index,row - 1,column,visited,board);
        dfs(s,index,row + 1,column,visited,board);
        dfs(s,index,row,column - 1,visited,board);
        dfs(s,index,row,column + 1,visited,board);
        visited[row][column] = false;
    }

    private static class Pair{
        private int x;
        private int y;

        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
