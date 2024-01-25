package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            char[] c = word.toCharArray();
            int s, e;
            for (s = 0, e = 0; e < c.length; e++) {
                if (c[e] == separator) {
                    if (s < e) {
                        result.add(new String(c, s, e - s));
                    }
                    s = e + 1;
                }
            }
            if (s < e) {
                result.add(new String(c, s, e - s));
            }
        }
        return result;
    }
}
