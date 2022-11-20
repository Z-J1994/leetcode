package medium;

public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [] p = {poured};
        double [] c;
        int row = 0;
        while(row < query_row){
            c = new double[p.length + 1];
            for(int i = 0;i < p.length;i++){
                if(p[i] > 1){
                    p[i] -= 1;
                    c[i] += p[i] / 2;
                    c[i + 1] = p[i] / 2;
                }
            }
            p = c;
            row++;
        }
        return p[query_glass] > 1 ? 1 : p[query_glass];
    }
}
