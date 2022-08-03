package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/8/1 12:48
 */
public class Solution1408 {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>(words.length);
        for (String d : words) {
            for (String word : words) {
                if (d.length() < word.length() && word.contains(d)) {
                    result.add(d);
                    break;
                }
            }
        }
        return result;
    }
}
