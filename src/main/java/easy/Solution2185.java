package easy;

/**
 * @author zhangjun
 * @version 2023/1/19
 */
public class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int c = 0;
        for(String word : words){
            if(word.startsWith(pref)){
                c++;
            }
        }
        return c;
    }
}
