package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/5/19
 */
public class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 1;j < column;j++){
                matrix[i][j]  ^= matrix[i][j - 1];
            }
        }

        for(int i = 0;i < column;i++){
            for(int j = 1;j < row;j++){
                matrix[j][i]  ^= matrix[j - 1][i];
            }
        }
        int length = row * column;
        int [] datas = new int[length];
        for(int i = 0,h = 0;i < row;i++){
            for(int j = 0;j < column;j++){
                datas[h++] = matrix[i][j];
            }
        }
        //可以用快速选择优化
        Arrays.sort(datas);
        return datas[length - k];
    }
}
