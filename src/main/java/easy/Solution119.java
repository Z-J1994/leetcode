package easy;

import java.util.ArrayList;

import java.util.List;

/**
 * @author zhangjun
 * @date 2021/2/12
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        int [] result = new int[rowIndex + 1];
        for(int i = 0;i <= rowIndex;i++){
            result[i] = 1;
        }

        for(int row = 2;row <= rowIndex;row++){
            for(int column = row - 1;column > 0;column--){
                result[column] += result[column - 1];
            }
        }

        ArrayList<Integer> list = new ArrayList<>(rowIndex + 1);
        for(int i = 0;i <= rowIndex;i++){
            list.add(result[i]);
        }

        return list;
    }

    public static void main(String [] args){
        Solution119 s = new Solution119();

        for(int i = 0;i < 34;i++){
            System.out.println(s.getRow(i).toString());
        }
    }

}
