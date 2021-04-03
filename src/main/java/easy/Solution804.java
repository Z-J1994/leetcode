package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2020/09/23  14:27
 */
public class Solution804 {

    public int uniqueMorseRepresentations(String[] words) {
        String [] strings = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---", ".--.","--.-",".-.","...","-","..-","...-"
                ,".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0;i < words.length;i++){
            for(int j = 0;j <words[i].length();j++){
                char c = words[i].charAt(j);
                s.append(strings[(c | 32) - 97]);
            }
            set.add(s.toString());
            s.delete(0,s.length());
        }
        return set.size();
    }
}
