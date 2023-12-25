package medium;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangjun
 * @since 2023/12/25 13:28
 */
public class Solution1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int x = (tomatoSlices >>> 1) - cheeseSlices;
        if((tomatoSlices & 1) == 1 || x < 0 || x > cheeseSlices){
            return Collections.emptyList();
        }
        return List.of(x,cheeseSlices - x);
    }
}
