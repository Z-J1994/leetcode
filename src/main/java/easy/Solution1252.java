package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  14:47
 */
public class Solution1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int [][] matrix = new int[n][m];
        for(int [] arrays : indices){
            int row = arrays[0];
            for(int k = 0;k < m;k++){
                matrix[row][k]++;
            }

            int column = arrays[1];
            for(int k = 0;k < n;k++){
                matrix[k][column]++;
            }
        }
        int count = 0;
        for(int [] arrays : matrix){
            for(int i:arrays){
                if(i % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
