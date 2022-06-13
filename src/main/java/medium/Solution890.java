package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        byte [] p = new byte[pattern.length()];
        for(int i = 0,l = pattern.length();i < l;i++){
            p[i] = (byte)(pattern.charAt(i) - 96);
        }
        List<String> result = new ArrayList<>(words.length);
        for(String word : words){
            if(check(word,p)){
                result.add(word);
            }
        }
        return result;
    }

    private boolean check(String s,byte [] pattern){
        byte[] map = new byte[27];
        byte[] reversedMap = new byte[27];
        for(int i = 0,index,l = s.length();i < l;i++){
            index = s.charAt(i) - 96;
            if(map[index] != map[reversedMap[pattern[i]]]){
                return false;
            }
            map[index] = pattern[i];
            reversedMap[pattern[i]] = (byte) index;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution890 s = new Solution890();
        System.out.println(s.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
