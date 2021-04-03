package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @date 2021/3/15
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null){
            return new ArrayList<>();
        }

        int up = 0;
        int down = matrix.length;
        if(down == 0){
            return new ArrayList<>();
        }

        int left = 0;
        int right = matrix[0].length;
        if(right == 0){
            return new ArrayList<>();
        }

        int length = down * right;
        Integer [] result = new Integer[length];

        for(int i = 0;i < length;){
            if(up < down){
                for(int column = left,row = up;column < right;++column,++i){
                    result[i] = matrix[row][column];
                }
                ++up;
            }

            if(left < right){
                for(int column = right - 1,row = up;row < down;++row,++i){
                    result[i] = matrix[row][column];
                }
                --right;
            }

            if(up < down){
                for(int column = right - 1,row = down - 1;column >= left;--column,++i){
                    result[i] = matrix[row][column];
                }
                --down;
            }

            if(left < right){
                for(int column = left,row = down - 1;row >= up;--row,++i){
                    result[i] = matrix[row][column];
                }
                ++left;
            }
        }

        return Arrays.asList(result);
    }
}
