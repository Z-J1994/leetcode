package medium;

/**
 * @author zhangjun
 * @version 2021/9/17
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        int [][] rmap = new int [10][10];
        int [][] cmap = new int [10][10];
        int [][] tmap = new int [9][10];

        for(int i = 0;i < row;i++){
            for(int j = 0;j < column;j++){
                int n = board[i][j] - 48;
                if(n <= 0){
                    continue;
                }
                if(rmap[i][n]++ != 0){
                    return false;
                }
                if(cmap[n][j]++ != 0){
                    return false;
                }
                if(tmap[i / 3 * 3 + j / 3][n]++ != 0){
                    return false;
                }
            }
        }


        return true;
    }
}
