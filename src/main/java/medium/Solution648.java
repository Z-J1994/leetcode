package medium;

import java.util.Comparator;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/7/7 12:43
 */
public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        dictionary.sort(Comparator.comparingInt(String::length));
        for (String s : sentence.split(" ")) {
            boolean replaced = false;
            for (String prefix : dictionary) {
                if (prefix.length() <= s.length()) {
                    if (s.startsWith(prefix)) {
                        sb.append(prefix);
                        replaced = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if(!replaced){
                sb.append(s);
            }
            sb.append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
