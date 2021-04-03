package medium;

/**
 * @author zhangjun
 * @date 2021/3/2
 */
public class Solution304 {
    private static class NumMatrix {
        private int [][] cache;
        public NumMatrix(int[][] matrix) {
            int rows = matrix.length + 1;
            int column = 1;
            if(rows != 1){
                column = matrix[0].length + 1;
            }
            cache = new int[rows][column];

            for(int i = 1;i < rows;i++){
                int p = cache[i][0];
                for(int j = 1,t;j < column;j++){
                    t = p + cache[i - 1][j] + matrix[i - 1][j - 1] - cache[i - 1][j - 1];
                    cache[i][j] = t;
                    p = t;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return cache[row2 + 1][col2 + 1] - cache[row2 + 1][col1] - cache[row1][col2 + 1] + cache[row1][col1];
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};


        NumMatrix n = new NumMatrix(matrix);
        System.out.println(n.sumRegion(2,1,4,3));//8
        System.out.println(n.sumRegion(1,1,2,2));//11
        System.out.println(n.sumRegion(1,2,2,4));//12
    }
}
