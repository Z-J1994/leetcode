package medium;

import utils.Parser;

public class Solution2397 {

    public int maximumRows(int[][] matrix, int numSelect) {
        int n = matrix.length,m = matrix[0].length;
        int [] compress = new int[n];
        for (int i = 0,b; i < n; i++) {
            b = 0;
            for (int j = 0; j < m; j++) {
                b |= matrix[i][j] << j;
            }
            compress[i] = b;
        }
        int max = 0;
        for (int i = 1,l = 1 << m,b; i < l; i++) {
            if(bitCount(i) <= numSelect){
                b = 0;
                for (int j = 0; j < n; j++) {
                    if((i | compress[j]) == i){
                        b++;
                    }
                }
                if(b > max){
                    max = b;
                }
            }
        }
        return max;
    }

    private int bitCount(int x){
        x = (x & 0x55555555) + ((x >>> 1) & 0x55555555);
        x = (x & 0x33333333) + ((x >>> 2) & 0x33333333);
        x = (x & 0x0F0F0F0F) + ((x >>> 4) & 0x0F0F0F0F);
        x = (x & 0x00FF00FF) + ((x >>> 8) & 0x00FF00FF);
        x = (x & 0x0000FFFF) + ((x >>> 16) & 0x0000FFFF);
        return x;
    }

    public static void main(String[] args) {
        Solution2397 s = new Solution2397();
        System.out.println(s.maximumRows(Parser.stringToIntMatrix("[[0,0,0],[1,0,1],[0,1,1],[0,0,1]]", 4, 3), 2) == 3);
        System.out.println(s.maximumRows(Parser.stringToIntMatrix("[[1,0,0,0,0,0,0],[0,1,0,1,1,1,1],[0,0,0,1,0,0,1]]", 3, 7), 5) == 2);
    }
}
