package medium;

/**
 * @author zhangjun
 * @version 2022/2/17
 */
public class Solution588 {
    private final int[][] factors = {{1, -2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}};

    private double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k];
        return dfs(k - 1, row, column);
    }

    private double dfs(int k, int row, int column) {
        if (row >= dp.length || row < 0 || column >= dp.length || column < 0) {
            return 0;
        }
        if (k < 0) {
            return 1;
        }
        if (dp[row][column][k] == 0) {
            double t = 0;
            for (int[] factor : factors) {
                t += dfs(k - 1, row + factor[0], column + factor[1]) / 8;
            }
            dp[row][column][k] = t;
        }
        return dp[row][column][k];
    }

    public static void main(String[] args) {
        Solution588 s = new Solution588();
        System.out.println(s.knightProbability(3, 2, 0, 0));
//        System.out.println(s.knightProbability(1, 0, 0, 0));
//        System.out.println(s.knightProbability(8, 13, 6, 4));
//        System.out.println(s.knightProbability(8, 100, 6, 4));
    }
}
