package hard;

import utils.Parser;

public class Solution782 {
    public int movesToChessboard(int[][] board) {
        int[] row = new int[board.length];
        int[] column = new int[board.length];
        for (int i = 0, t = 0; i < board.length; i++,t = 0) {
            for (int j = 0; j < board.length; j++) {
                t = (t << 1) | board[i][j];
                column[j] = (column[j] << 1) | board[i][j];
            }
            row[i] = t;
        }
        int r = getStep(row);
        if (r == -1) {
            return -1;
        }
        int g = getStep(column);
        if (g == -1) {
            return -1;
        }
        return r + g;
    }

    private int getStep(int[] element) {
        int mask = (1 << element.length) - 1;
        int a = element[0];
        int b = 0;
        int aCount = 1;
        int bCount = 0;
        for (int i = 1, t; i < element.length; i++) {
            if ((t = (a ^ element[i])) == 0) {
                aCount++;
            } else if (t == mask) {
                bCount++;
                b = element[i];
            } else {
                return -1;
            }
        }
        if (aCount == bCount) {
            return Math.min(getStep(element, a, b), getStep(element, b, a));
        } else if (aCount - bCount == 1) {
            return getStep(element, a, b);
        } else if (bCount - aCount == 1) {
            return getStep(element, b, a);
        }
        return -1;
    }

    private int getStep(int[] element, int a, int b) {
        int c = 0;
        for (int i = 0, l = element.length - (element.length & 1); i < l; i += 2) {
            if (element[i] != a) {
                c++;
            }
            if (element[i + 1] != b) {
                c++;
            }
        }
        if ((element.length & 1) == 1 && element[element.length - 1] != a) {
            c++;
        }
        return c / 2;
    }

    public static void main(String[] args) {
        Solution782 s = new Solution782();
        System.out.println(s.movesToChessboard(Parser.stringToIntMatrix("[[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]", 4, 4)) == 2);
        System.out.println(s.movesToChessboard(Parser.stringToIntMatrix("[[0,1],[1,0]]", 2, 2)) == 0);
        System.out.println(s.movesToChessboard(Parser.stringToIntMatrix("[[1,0],[1,0]]", 2, 2)) == -1);
    }
}
