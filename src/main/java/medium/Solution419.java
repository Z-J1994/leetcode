package medium;

public class Solution419 {
    public int countBattleships(char[][] board) {
        int count = board[0][0] == 'X' ? 1 : 0;
        for(int i = 1;i < board[0].length;i++){
            if(board[0][i] == 'X' && board[0][i - 1] != 'X'){
                count++;
            }
        }
        for(int i = 1;i < board.length;i++){
            if(board[i][0] == 'X' && board[i - 1][0] != 'X'){
                count++;
            }
            for(int j = 1;j < board[i].length;j++){
                if(board[i][j] == 'X' && board[i][j - 1] != 'X' && board[i - 1][j] != 'X'){
                    count++;
                }
            }
        }
        return count;
    }
}
