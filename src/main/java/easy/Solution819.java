package easy;

import java.util.*;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);
        Map<String, Integer> map = new HashMap<>();
        char[] value = new char[paragraph.length()];
        int index = 0;
        char c;
        int max = 0, t;
        String result = null;
        for (int i = 0, l = paragraph.length(); i < l; i++) {
            c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z') {
                value[index++] = c;
            } else if (c >= 'A' && c <= 'Z') {
                value[index++] = (char) (c + 32);
            } else if (index != 0){
                String s = new String(value, 0, index);
                index = 0;
                if (s.length() <= 10 && bannedSet.contains(s)) {
                    continue;
                }
                map.put(s, t = (map.getOrDefault(s, 0) + 1));
                if (t > max) {
                    max = t;
                    result = s;
                }
            }
        }
        if (index > 0) {
            String s = new String(value, 0, index);
            if (s.length() > 10 || !bannedSet.contains(s)) {
                map.put(s, t = (map.getOrDefault(s, 0) + 1));
                if (t > max) {
                    result = s;
                }
            }
        }
        return result;
    }
}
