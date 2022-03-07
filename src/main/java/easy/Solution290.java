package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2022/3/7
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] marked = new String[26];
        int from, end = 0;
        char c;
        Character ch;
        Map<String,Character> map = new HashMap<>();
        int i;
        for (i = 0; i < pattern.length() && end < s.length(); i++, end++) {
            from = end;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            c = pattern.charAt(i);
            String sub = s.substring(from, end);
            if(marked[c - 97] == null){
                if((ch = map.get(sub)) != null && ch != c){
                    return false;
                }
                marked[c - 97] = sub;
                map.put(sub,c);
            }else if(!marked[c - 97].equals(sub)){
                return false;
            }
        }
        return end >= s.length() && i >= pattern.length();
    }
}
