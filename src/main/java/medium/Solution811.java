package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            char[] chars = s.toCharArray();
            int j = -1;
            int n = 0;
            while (++j < chars.length && chars[j] != ' ') {
                n = n * 10 + chars[j] - '0';
            }
            String key;
            for (int i = chars.length - 1; i > j; i--) {
                if (chars[i] == '.') {
                    key = new String(chars, i + 1, chars.length - i - 1);
                    map.put(key, map.getOrDefault(key, 0) + n);
                }
            }
            key = new String(chars, j + 1, chars.length - j - 1);;
            map.put(key, map.getOrDefault(key, 0) + n);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
