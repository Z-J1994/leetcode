package medium;

/**
 * @author zhangjun
 * @since 2022/6/14 12:58
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int maxRow = mat.length;
        int maxColum = mat[0].length;
        int length = mat.length * mat[0].length;
        int [] result = new int[length];
        int row = 0,colum = 0;
        for(int i = 0,r = -1,c = 1;i < length;){
            while(row >= 0 && row < maxRow && colum >= 0 && colum < maxColum){
                result[i++] = mat[row][colum];
                row += r;
                colum += c;
            }
            r = -r;
            c = -c;
            if(colum == maxColum){
                colum--;
                row += 2;
            }else if(row < 0){
                row = 0;
            }

            if(row == maxRow){
                row--;
                colum += 2;
            }else if(colum < 0){
                colum = 0;
            }
        }
        return result;
    }
}
