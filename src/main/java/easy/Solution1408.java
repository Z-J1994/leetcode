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
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>(words.length);
        for(int i = 0;i < words.length;i++){
            String d = words[i];
            for(int j = i + 1;j < words.length;j++){
                if(d.length() < words[j].length() && words[j].contains(d)){
                    result.add(d);
                    break;
                }
            }
        }
        return result;
    }
}
