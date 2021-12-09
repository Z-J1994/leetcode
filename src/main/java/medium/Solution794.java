package medium;

public class Solution794 {
    private int xTarget = 0;
    private int oTarget = 0;

    public boolean validTicTacToe(String[] board) {
        char[][] cBoard = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                switch ((cBoard[i][j] = s.charAt(j))) {
                    case 'X':
                        ++xTarget;
                        break;
                    case 'O':
                        ++oTarget;
                        break;
                }
            }
        }
        int t = xTarget - oTarget;
        if (t < 0 || t > 1) {
            return false;
        }
        boolean a = win(cBoard, 'X');
        if (a && t == 0) {
            return false;
        }
        boolean b = win(cBoard, 'O');
        return !b || t <= 0;
    }


    private boolean win(char[][] board, char t) {
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != t || board[i][1] != t || board[i][2] != t) {
                c++;
            }
            if (board[0][i] != t || board[1][i] != t || board[2][i] != t) {
                d++;
            }
            if (board[i][i] == t) {
                e++;
            }
            if (board[i][2 - i] == t) {
                f++;
            }
        }
        return c != 3 || d != 3 || e == 3 || f == 3;
    }
}
