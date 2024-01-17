package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @since 2024/1/17 13:05
 */
public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for(String word : words){
            if(set.remove(word)){
                count++;
            }else{
                set.add(reverse(word));
            }
        }
        return count;
    }
    private String reverse(String s){
        char [] chars = s.toCharArray();
        for(int i = 0,j = chars.length - 1;i < j;i++,j--){
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        return new String(chars);
    }
}
