package medium;

/**
 * @author zhangjun
 * @date 2021/3/21
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean marked = false;

        for(int i = 0;i < rows;i++){
            if(matrix[i][0] == 0){
                marked = true;
            }
            for(int j = 1;j < columns;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = rows - 1;i >= 0;i--){
            for(int j = columns - 1;j > 0;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(marked){
                matrix[i][0] = 0;
            }
        }
    }
}
