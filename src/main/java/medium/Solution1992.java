package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2024/4/20 13:20
 */
public class Solution1992 {
    public int[][] findFarmland(int[][] land) {
        for(int i = 1;i < land.length;i++){
            for(int j = 0;j < land[0].length;j++){
                if(land[i][j] != 0){
                    land[i][j] += land[i - 1][j];
                    land[i - 1][j] = 0;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0,j,c,p;i < land.length;i++){
            for(c = 0,j = 0,p = 0;j < land[0].length;j++){
                if(p != land[i][j]){
                    if(land[i][j] == 0){
                        list.add(new int[]{i - p + 1,j - c,i,j - 1});
                    }
                    p = land[i][j];
                    c = 1;
                }else{
                    ++c;
                }
            }
            if(p != 0 && c != 0){
                list.add(new int[]{i - p + 1,j - c,i,j - 1});
            }
        }
        int [][] result = new int[list.size()][];
        int index = 0;
        for(int [] r : list){
            result[index++] = r;
        }
        return result;
    }
}
