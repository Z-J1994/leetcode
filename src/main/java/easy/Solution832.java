package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  15:12
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int column = A[0].length - 1;
        for(int r = 0;r < rows;r++){
            for(int i = 0,j = column;i <= j;i++,j--){
                int t = A[r][i] ^ 1;
                A[r][i] = A[r][j] ^ 1;
                A[r][j] = t;
            }
        }
        return A;
    }
}
