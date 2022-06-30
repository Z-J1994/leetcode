package easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangjun
 * @since 2022/6/30 12:46
 */
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0){
            return new int[0];
        }
        int[][] element = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            element[i][0] = arr[i];
            element[i][1] = i;
        }
        Arrays.sort(element, Comparator.comparingInt(e -> e[0]));
        int [] result = new int[arr.length];
        int rank = 1;
        result[element[0][1]] = rank;
        for(int i = 1;i < arr.length;i++){
            if(element[i][0] != element[i - 1][0]){
                rank++;
            }
            result[element[i][1]] = rank;
        }
        return result;
    }
}
