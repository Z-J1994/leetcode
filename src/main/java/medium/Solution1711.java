package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/7/7
 */
public class Solution1711 {
    public int countPairs(int[] deliciousness) {
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : deliciousness){
            for(int j = 0;j < 30;++j){
                int key = (1 << j) - t;
                if(key >= 0){
                    count = (count + map.getOrDefault(key,0));
                }
            }
            int n = map.getOrDefault(t,0);
            map.put(t,n + 1);
        }
        return (int)(count % 1000000007);
    }
}
