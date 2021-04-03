package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @date 2021/1/26
 */
public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {

        int [][] array = new int[10][10];

        for(int [] d:dominoes){
            array[d[0]][d[1]]++;
        }

        int result = 0;
        for(int i = 0;i < 10;i++){
            int t = array[i][i];
            result += t * (t - 1) / 2;
            for(int j = i + 1;j < 10;j++){
                t = array[i][j] + array[j][i];
                result += t * (t - 1) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1128 s = new Solution1128();
        int [][] dominoes1 = {{1,2},{2,1},{3,4},{1,2}};
        int [][] dominoes2 = {{1,2},{2,1},{3,4},{5,6}};
        int [][] dominoes3 = {{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};

        System.out.println(s.numEquivDominoPairs(dominoes1));//3
        System.out.println(s.numEquivDominoPairs(dominoes2));//1
        System.out.println(s.numEquivDominoPairs(dominoes3));
    }
}
