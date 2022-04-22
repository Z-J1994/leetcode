package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        String [] ss1 = s1.split(" ");
        String [] ss2 = s2.split(" ");
        for (String s : ss1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : ss2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        map.entrySet().removeIf(stringIntegerEntry -> stringIntegerEntry.getValue() > 1);
        return map.keySet().toArray(new String[0]);
    }
}
