package hard;

import utils.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/5/26 13:14
 */
public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        int [][] sorted = new int[positions.length][3];
        List<Integer> result = new ArrayList<>();
        for(int i = 0,left,right,height,maxHeight = 0;i < positions.length;i++){
            left = positions[i][0];
            right = positions[i][0] + positions[i][1];
            height = 0;
            for(int j = 0;j < i && sorted[j][0] < right;j++){
                if(sorted[j][0] + sorted[j][1] > left || sorted[j][0] >= left){
                    if(sorted[j][2] > height){
                        height = sorted[j][2];
                    }
                }
            }
            sorted[i][0] = left;
            sorted[i][1] = positions[i][1];
            sorted[i][2] = height + positions[i][1];
            if(sorted[i][2] > maxHeight){
                maxHeight = sorted[i][2];
            }
            result.add(maxHeight);
            insertionSort(sorted,i);
        }
        return result;
    }

    private void insertionSort(int [][] data,int targetIndex){
        int [] temp = data[targetIndex];
        while(--targetIndex >= 0 && temp[0] < data[targetIndex][0]){
            data[targetIndex + 1] = data[targetIndex];
        }
        data[targetIndex + 1] = temp;
    }

    public static void main(String[] args) {
        Solution699 s = new Solution699();
        System.out.println(s.fallingSquares(Parser.stringToIntMatrix("[[1,2],[2,3],[6,1]]", 2)));
    }
}
