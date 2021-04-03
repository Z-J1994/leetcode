package easy;

/**
 * @author zhangjun
 * @version 2020/09/30  14:55
 */
public class Solution999 {
    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int count = 0;

        for(int i = y + 1;i < board[x].length;i++){
            if(board[x][i] == 'B'){
                break;
            }
            if(board[x][i] == 'p'){
                count++;
                break;
            }
        }

        for(int i = y - 1;i >= 0;i--){
            if(board[x][i] == 'B'){
                break;
            }
            if(board[x][i] == 'p'){
                count++;
                break;
            }
        }

        for(int i = x - 1;i >= 0;i--){
            if(board[i][y] == 'B'){
                break;
            }
            if(board[i][y] == 'p'){
                count++;
                break;
            }
        }

        for(int i = x + 1;i < board.length;i++){
            if(board[i][y] == 'B'){
                break;
            }
            if(board[i][y] == 'p'){
                count++;
                break;
            }
        }
        return count;
    }
}
