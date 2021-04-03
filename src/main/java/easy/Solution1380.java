package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/26  19:25
 */
public class Solution1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new LinkedList<>();

        for(int i = 0;i < matrix.length;i++){
            int min = 0;
            for(int j = 1;j < matrix[i].length;j++){
                if(matrix[i][j] < matrix[i][min]){
                    min = j;
                }
            }
            int f = 0;
            int minC = i;
            for(int j = 0;j < matrix.length;j++){
                if(matrix[j][min] > matrix[minC][min]){
                    f = 1;
                    break;
                }
            }
            if(f == 0){
                list.add(matrix[i][min]);
            }
        }
        return list;
    }
}
