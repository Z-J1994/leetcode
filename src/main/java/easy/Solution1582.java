package easy;

public class Solution1582 {
    public int numSpecial(int[][] mat) {
        int [] row = new int[mat[0].length];
        int [] column = new int[mat.length];
        for(int i = 0;i < mat.length;i++){
            int p = -1;
            for(int j = 0;j < mat[0].length;j++){
                row[j] += mat[i][j];
                if(mat[i][j] == 1){
                    column[i]++;
                    p = j;
                }
            }
            if(column[i] == 1){
                column[i] = p;
            }else{
                column[i] = -1;
            }
        }

        int r = 0;
        for (int j : column) {
            if (j >= 0 && row[j] == 1) {
                r++;
            }
        }
        return r;
    }
}
