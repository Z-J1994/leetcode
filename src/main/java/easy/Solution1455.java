package easy;

/**
 * @author zhangjun
 * @version 2020/10/03  21:56
 */
public class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int [] next = KMP(searchWord);
        int count = 1;
        int k = 0;
        boolean mark = true;
        for(int i = 0;i < sentence.length();i++){
            char c = sentence.charAt(i);
            if(c == ' '){
                mark = true;
                count++;
                continue;
            }
            while(k > 0 && searchWord.charAt(k) != c){
                k = next[k];
            }
            if(searchWord.charAt(k) != c){
                mark = false;
            }
            if (!mark){
                continue;
            }
            if(searchWord.charAt(k) == c){
                k++;
            }
            if(k == searchWord.length()){
                return count;
            }
        }
        return -1;
    }

    private int[] KMP(String pattern){
        int [] next = new int[pattern.length()];
        next[0] = 0;
        for(int i = 1,k = 0;i < next.length;i++){
            while(k > 0 && pattern.charAt(i) != pattern.charAt(k)){
                k = next[k];
            }
            if(pattern.charAt(i) == pattern.charAt(k)){
                next[i] = k++;
            }else{
                next[i] = k;
            }
        }
        return next;
    }
}
