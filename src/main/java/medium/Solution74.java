package medium;

/**
 * @author zhangjun
 * @date 2021/3/30
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x1 = 0;
        int y1 = 0;
        int y2 = matrix.length - 1;
        int column = matrix[0].length;
        int x2 = column - 1;

        while(y1 < y2 || (y1 == y2 && x1 <= x2)){
            int step = ((y2 - y1) * column + x2 - x1) / 2;
            int my = y1 + step / column;
            int mx = x1 + step % column;
            if(mx >= column){
                mx -= column;
                ++my;
            }
            if(matrix[my][mx] > target){
                y2 = my;
                x2 = mx - 1;
                if(x2 == -1){
                    x2 = column - 1;
                    --y2;

                }
            }else if(matrix[my][mx] < target){
                y1 = my;
                x1 = mx + 1;
                if(x1 >= column){
                    x1 -= column;
                    ++y1;
                }
            }else{
                return true;
            }
        }
        return false;
    }
}
