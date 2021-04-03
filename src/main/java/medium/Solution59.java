package medium;

/**
 * @author zhangjun
 * @date 2021/3/16
 */
public class Solution59 {

    public int[][] generateMatrix(int n) {

        int [][] matrix = new int[n][n];

        int up = 0;
        int down = n;

        int left = 0;
        int right = n;

        int length = down * right;
        int number = 1;

        for(int i = 0;i < length;){
            if(up < down){
                for(int column = left,row = up;column < right;++column,++i){
                    matrix[row][column] = number++;
                }
                ++up;
            }

            if(left < right){
                for(int column = right - 1,row = up;row < down;++row,++i){
                    matrix[row][column] = number++;
                }
                --right;
            }

            if(up < down){
                for(int column = right - 1,row = down - 1;column >= left;--column,++i){
                    matrix[row][column] = number++;
                }
                --down;
            }

            if(left < right){
                for(int column = left,row = down - 1;row >= up;--row,++i){
                    matrix[row][column] = number++;
                }
                ++left;
            }
        }

        return matrix;
    }

}
