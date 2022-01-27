package hard;

/**
 * @author zhangjun
 * @version 2022/1/27
 */
public class Solution37 {
    private final boolean[][] m1 = new boolean[9][10];
    private final boolean[][] m2 = new boolean[9][10];
    private final boolean[][] m3 = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        int sum = 0;
        for (int i = 0,k; i < 9; i++) {
            k = (i / 3) * 3;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    ++sum;
                }else{
                    int h = board[i][j] - '0';
                    m1[i][h] = true;
                    m2[j][h] = true;
                    m3[k + j / 3][h] = true;
                }
            }
        }
        dfs(board, 0, 0, sum);
    }

    private boolean dfs(char[][] board, int x, int y, int count) {
        if (count == 0) {
            return true;
        }
        boolean loop = true;
        while (x < 9) {
            while (y < 9) {
                if (board[x][y] == '.') {
                    loop = false;
                    break;
                }
                ++y;
            }
            if (!loop) {
                break;
            }
            y = 0;
            ++x;
        }
        if (x >= 9) {
            return false;
        }
        int k = (x / 3) * 3 + y / 3;
        for (int i = 1; i < 10; i++) {
            if (!m1[x][i] && !m2[y][i] && !m3[k][i]) {
                board[x][y] = (char) (i + '0');
                m1[x][i] = true;
                m2[y][i] = true;
                m3[k][i] = true;
                if(dfs(board, x, y + 1, count - 1)){
                    return true;
                }
                board[x][y] = '.';
                m1[x][i] = false;
                m2[y][i] = false;
                m3[k][i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution37 s = new Solution37();
        char[][] board =
                        {{'.', '3', '4', '6', '7', '8', '9', '1', '2'},
                        {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                        {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                        {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                        {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                        {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                        {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                        {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                        {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

        s.solveSudoku(board);
    }
}
