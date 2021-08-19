package easy;

/**
 * @author zhangjun
 * @version 2021/8/19
 */
public class Solution345 {
    public String reverseVowels(String s) {
        char [] chars = s.toCharArray();
        int i = -1,j = s.length();
        while(true){
            while(++i < j && !isVowel(chars[i]));
            while(i < --j && !isVowel(chars[j]));
            if(i >= j){
                break;
            }
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        return new String(chars);
    }
    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' ||c == 'i' ||c == 'o' || c == 'u') || (c == 'A' || c == 'E' ||c == 'I' ||c == 'O' || c == 'U');
    }
}
