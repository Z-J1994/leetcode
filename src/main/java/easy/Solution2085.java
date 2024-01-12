package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @since 2024/1/12 13:31
 */
public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        put(map, words1, 3000);
        put(map, words2, 1);
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3001) {
                count++;
            }
        }
        return count;
    }

    private void put(Map<String, Integer> map, String[] worlds, int d) {
        for (String w : worlds) {
            Integer count = map.get(w);
            if (count == null) {
                count = d;
            } else {
                count += d;
            }
            map.put(w, count);
        }
    }
}
