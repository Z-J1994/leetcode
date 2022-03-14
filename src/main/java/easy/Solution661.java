package easy;

/**
 * @author zhangjun
 * @version 2022/3/14
 */
public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int column = img[0].length;
        int[][] result = new int[row][column];
        for(int i = 0;i < row;i++){
            for(int j = 0,s,v;j < column;j++){
                boolean b1 = j >= 1;
                boolean b2 = j + 1 < column;
                s = img[i][j];
                v = 1;
                if(i >= 1){
                    v++;
                    s += img[i - 1][j];
                    if(b1){
                        v++;
                        s += img[i - 1][j - 1];
                    }
                    if(b2){
                        v++;
                        s += img[i - 1][j + 1];
                    }
                }
                if(i + 1 < row){
                    s += img[i + 1][j];
                    v++;
                    if(b1){
                        v++;
                        s += img[i + 1][j - 1];
                    }
                    if(b2){
                        v++;
                        s += img[i + 1][j + 1];
                    }
                }
                if(b1){
                    s += img[i][j - 1];
                    v++;
                }
                if(b2){
                    v++;
                    s += img[i][j + 1];
                }
                result[i][j] = s / v;
            }
        }
        return result;
    }
}
