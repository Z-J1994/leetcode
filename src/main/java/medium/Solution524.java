package medium;

import java.util.List;

/**
 * @author zhangjun
 * @version 2021/9/14
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        int max = 0;
        for(String s1: dictionary){
            int l = s1.length();
            if(l < max){
                continue;
            }
            if(equals(s1,s)){
                if(l > max){
                    result = s1;
                    max = l;
                }else if(s1.compareTo(result) < 0){
                    result = s1;
                }
            }
        }
        return result;
    }

    private boolean equals(String pattern,String text){
        int pl = pattern.length();
        int index = 0;
        for(int i = 0,l = text.length();i < l && index < pl;i++){
            if(text.charAt(i) == pattern.charAt(index)){
                index++;
            }
        }
        return index == pl;
    }
}
