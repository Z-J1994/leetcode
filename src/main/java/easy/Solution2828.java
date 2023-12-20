package easy;

import java.util.List;

/**
 * @author zhangjun
 * @since 2023/12/20 12:23
 */
public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        int i = 0;
        for (String word : words) {
            if (word.charAt(0) != s.charAt(i++)) {
                return false;
            }
        }
        return true;
    }
}
