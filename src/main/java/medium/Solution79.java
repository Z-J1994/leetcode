package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2024/4/3 13:24
 */
public class Solution79 {
    private static final int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        char [] chars = word.toCharArray();
        boolean [][] visited = new boolean [board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(dfs(board,visited,i,j,chars,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,boolean [][] visited,int i,int j,char [] chars,int offset){
        if(board[i][j] != chars[offset]){
            return false;
        }
        if(offset == chars.length - 1){
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        for(int [] direction : directions){
            int ii = i + direction[0],jj = j + direction[1];
            if(ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && !visited[ii][jj]){
                result |= dfs(board,visited,ii,jj,chars,offset + 1);
            }

        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution79 s = new Solution79();
        System.out.println(s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

}
