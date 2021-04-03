package hard;
import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/12/26/ 15:17
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {

        int column = matrix.length;
        if(column == 0){
            return 0;
        }
        int row = matrix[0].length;
        int [] height = new int[row];
        int [] start = new int[row];
        int [] end = new int[row];

        for(int i = 0;i < row;i++){
            end[i] = row;
        }

        int maxArea = 0;
        for(int i = 0;i < column;i++){

            for(int j = 0;j < row;j++){
                if(matrix[i][j] == '1'){
                    ++height[j];
                }else{
                    height[j] = 0;
                }
            }
            int c = 0;
            for(int j = 0;j < row;j++){
                if(matrix[i][j] =='1'){
                    int t = start[j];
                    start[j] = (t > c) ? t : c;
                }else{
                    c = j + 1;
                    start[j] = 0;
                }
            }
            c = row;
            for(int j = row - 1;j >= 0;j--){
                if(matrix[i][j] =='1'){
                    int t = end[j];
                    end[j] = (t < c) ? t : c;
                }else{
                    c = j;
                    end[j] = row;
                }
            }
            System.out.println(Arrays.toString(height));
            for(int j = 0;j < row;j++){
                int t = height[j] * (end[j] - start[j]);
                maxArea = (maxArea > t) ? maxArea : t;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution85 s = new Solution85();
        char [][] m = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char [][] m1 = {};
        char [][] m2 = {{'0'}};
        char [][] m3 = {{'1'}};
        char [][] m4 = {{'0','0'}};
        char [][] m5 = {{'0','0','1'},{'1','1','1'}};
        char [][] m6 = {{'0','0','0','0','0','0','1'},{'0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1'},{'0','0','0','1','1','1','1'}};
        char [][] m7 = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
        System.out.println(s.maximalRectangle(m));//6
        System.out.println(s.maximalRectangle(m1));//0
        System.out.println(s.maximalRectangle(m2));//0
        System.out.println(s.maximalRectangle(m3));//1
        System.out.println(s.maximalRectangle(m4));//0
        System.out.println(s.maximalRectangle(m5));//3
        System.out.println(s.maximalRectangle(m6));//9
        System.out.println(s.maximalRectangle(m7));//9

    }
}
