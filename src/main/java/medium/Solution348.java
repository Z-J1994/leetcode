package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution348 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] map = new int[26];
        int differences = p.length();
        for (int i = 0; i < differences; i++) {
            map[p.charAt(i) - 97]++;
        }

        int[] content = new int[26];
        for (int i = 0; i < p.length(); i++) {
            if (++content[s.charAt(i) - 97] <= map[s.charAt(i) - 97]) {
                differences--;
            }
        }
        if (differences == 0) {
            result.add(0);
        }
        for (int i = p.length(), start = 0; i < s.length(); i++) {
            if (s.charAt(start) != s.charAt(i)) {
                if (content[s.charAt(start) - 97]-- <= map[s.charAt(start) - 97]) {
                    differences++;
                }
                if (++content[s.charAt(i) - 97] <= map[s.charAt(i) - 97]) {
                    differences--;
                }
            }
            start++;
            if (differences == 0) {
                result.add(start);
            }
        }
        return result;
    }
}
