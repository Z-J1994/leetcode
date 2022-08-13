package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/8/12 13:25
 */
public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        @SuppressWarnings("unchecked")
        List<Integer> [] map = new List[groupSizes.length + 1];
        List<List<Integer>> result = new ArrayList<>();
        int k = 0;
        for(int i : groupSizes){
            if(map[i] == null || map[i].size() >= i){
                map[i] = new ArrayList<>();
                result.add(map[i]);
            }
            map[i].add(k);
            k++;
        }
        return result;
    }
}
