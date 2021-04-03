package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  14:19
 */
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int sum = 0, n = mat.length, mid = n >> 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += (mat[i][i] + mat[i][j]);
        }
        return n % 2 == 0 ? sum : sum - mat[mid][mid];
    }
}
