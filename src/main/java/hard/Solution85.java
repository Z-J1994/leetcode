package hard;

/**
 * @author zhangjun
 * @version 2020/12/26/ 15:17
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length, max = 0;
        int[] oneLine = new int[columns];
        int[][] d = new int[columns + 1][2];
        d[0][0] = -1;
        for (int i = 0, top; i < rows; i++) {
            top = 0;
            for (int j = 0, t, c; j < columns; j++) {
                c = (matrix[i][j] - '0');
                t = (c * oneLine[j] + c);
                oneLine[j] = t;
                if (d[top][0] >= t) {
                    while (d[top][0] >= t) {
                        max = Math.max(max, (j - d[top][1]) * d[top][0]);
                        --top;
                    }
                    d[++top][0] = t;
                    max = Math.max(max, (j - d[top][1]) * t);
                } else {
                    d[++top][0] = t;
                    d[top][1] = j;
                }
            }
            while (top > 0) {
                max = Math.max(max, (columns - d[top][1]) * d[top][0]);
                --top;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution85 s = new Solution85();
        char[][] m = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        char[][] m2 = {{'0'}};
        char[][] m3 = {{'1'}};
        char[][] m4 = {{'0', '0'}};
        char[][] m5 = {{'0', '0', '1'}, {'1', '1', '1'}};
        char[][] m6 = {{'0', '0', '0', '0', '0', '0', '1'}, {'0', '0', '0', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1'}, {'0', '0', '0', '1', '1', '1', '1'}};
        char[][] m7 = {{'0', '1', '1', '0', '1'}, {'1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}};
        char[][] m8 = {{'1', '1'}};
        System.out.println(s.maximalRectangle(m) == 6);
        System.out.println(s.maximalRectangle(m2) == 0);
        System.out.println(s.maximalRectangle(m3) == 1);
        System.out.println(s.maximalRectangle(m4) == 0);
        System.out.println(s.maximalRectangle(m5) == 3);
        System.out.println(s.maximalRectangle(m6) == 9);
        System.out.println(s.maximalRectangle(m7) == 9);
        System.out.println(s.maximalRectangle(m8) == 2);


    }
}
