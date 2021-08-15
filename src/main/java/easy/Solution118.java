package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/8/14
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(1);
        result.add(level);
        if(numRows == 1){
            return result;
        }
        List<Integer> previous;
        for(int i = 1;i < numRows;i++){
            previous = level;
            level = new ArrayList<>();
            level.add(1);
            for(int j = 1;j < i;j++){
                level.add(previous.get(j - 1) + previous.get(j));
            }
            level.add(1);
            result.add(level);
        }
        return result;

    }
}
