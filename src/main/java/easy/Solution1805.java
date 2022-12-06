package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2022/12/6
 */
public class Solution1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int j = 0,l = word.length();
        for(int i = 0;i < l;i++){
            if(word.charAt(i) >= 'a'){
                if(i - j > 0){
                    set.add(getStringNumber(word,j,i));
                }
                j = i + 1;
            }
        }
        if(j < l){
            set.add(getStringNumber(word,j,l));
        }
        return set.size();
    }

    private String getStringNumber(String word,int start,int end){
        while (start < end && word.charAt(start) == '0'){
            start++;
        }
        if(start == end){
            return "0";
        }
        return word.substring(start,end);
    }
}
