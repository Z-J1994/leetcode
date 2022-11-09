package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @version 2022/11/9
 */
public class Solution764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] origin = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                origin[i][j] = 1;
            }
        }
        for(int [] mine : mines){
            origin[mine[0]][mine[1]] = 0;
        }

        int [][] top = new int[n][n];
        for(int j = 0;j < n;j++){
            top[0][j] = origin[0][j];
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < n;j++){
                top[i][j] = origin[i][j] * top[i - 1][j] + origin[i][j];
            }
        }
        int [][] bottom = new int[n][n];
        for(int j = 0,t = n - 1;j < n;j++){
            bottom[t][j] = origin[t][j];
        }
        for(int i = n - 2;i >= 0;i--){
            for(int j = 0;j < n;j++){
                bottom[i][j] = origin[i][j] * bottom[i + 1][j] + origin[i][j];
            }
        }

        int [][] left = new int[n][n];
        for(int j = 0;j < n;j++){
            left[j][0] = origin[j][0];
        }
        for(int i = 0;i < n;i++){
            for(int j = 1;j < n;j++){
                left[i][j] = origin[i][j] * left[i][j - 1] + origin[i][j];
            }
        }

        int [][] right = new int[n][n];
        for(int j = 0,t = n - 1;j < n;j++){
            right[j][t] = origin[j][t];
        }
        for(int i = 0;i < n;i++){
            for(int j = n - 2;j >= 0;j--){
                right[i][j] = origin[i][j] * right[i][j + 1] + origin[i][j];
            }
        }
        int result = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                result = Math.max(result,min(top[i][j],bottom[i][j],left[i][j],right[i][j]));
            }
        }
        return result;
    }

    private int min(int ... elements){
        int min = 0x7fffffff;
        for(int element : elements){
            if(min > element){
                min = element;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Solution764 s = new Solution764();
        System.out.println(s.orderOfLargestPlusSign(5, Parser.stringToIntMatrix("[[4,2]]", 1, 2)) == 2);
        System.out.println(s.orderOfLargestPlusSign(2, Parser.stringToIntMatrix("[[0,0],[0,1],[1,0]]", 3, 2)) == 1);
        System.out.println(s.orderOfLargestPlusSign(2, Parser.stringToIntMatrix("[[0,1],[1,0],[1,1]]", 3, 2)) == 1);
    }
}
