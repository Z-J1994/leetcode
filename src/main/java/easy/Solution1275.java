package easy;

/**
 * @author zhangjun
 * @since 2022/6/24 13:21
 */
public class Solution1275 {
    /*
     * 棋盘转二进制
     * -------------------
     * |  0  |  1  |  2  |
     * -------------------          --------------------------------------
     * |  3  |  4  |  5  | ========>    8   7   6   5   4   3   2   1   0
     * -------------------          --------------------------------------
     * |  6  |  7  |  8  |
     * -------------------
     *
     */
    public String tictactoe(int[][] moves) {
        int [] player = new int[2];
        int i = 0;
        for(int [] move:moves){
            i &= 1;
            player[i] |= 1 << (move[0] * 3 + move[1]);
            if(check(player[i])){
                return i == 0 ? "A" : "B";
            }
            i++;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
    private boolean check(int a){
        return  check(a,7) || check(a,56) || check(a,448) || check(a,292) || check(a,146) || check(a,73) || check(a,273) || check(a,84);
    }

    private boolean check(int a,int b){
        return (a & b) == b;
    }
}
