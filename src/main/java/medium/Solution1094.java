package medium;

/**
 * @author zhangjun
 * @since 2023/12/2 13:32
 */
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] map = new int[1001];
        for(int [] trip : trips){
            map[trip[1]] += trip[0];
            map[trip[2]] -= trip[0];
        }
        for(int i : map){
            capacity -= i;
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }
}
