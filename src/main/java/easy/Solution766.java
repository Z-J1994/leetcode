package easy;

/**
 * @author zhangjun
 * @date 2021/2/22
 */
public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        for(int r = 1;r < row;r++){
            for(int c = 1;c < column;c++){
                if(matrix[r][c] != matrix[r - 1][c - 1]){
                    return false;
                }
            }
        }

        return true;
    }
}
