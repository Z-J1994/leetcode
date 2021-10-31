package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution500 {
    private static final int [] dictionary = new int[124];

    static{
        String s1 = "asdfghjkl";
        String s2 = "zxcvbnm";
        for(int i = 0;i < s1.length();i++){
            dictionary[s1.charAt(i)] = 1;
            dictionary[s1.charAt(i) - 32] = 1;
        }

        for(int i = 0;i < s2.length();i++){
            dictionary[s2.charAt(i)] = 2;
            dictionary[s2.charAt(i) - 32] = 2;
        }
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>(words.length);
        for(String s:words){
            boolean mark = true;
            for(int i = 1;i < s.length();i++){
                if(dictionary[s.charAt(i - 1)] != dictionary[s.charAt(i)]){
                    mark = false;
                    break;
                }
            }
            if(mark){
                result.add(s);
            }
        }
        return result.toArray(new String [0]);
    }
}
