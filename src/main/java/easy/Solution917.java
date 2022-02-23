package easy;

/**
 * @author zhangjun
 * @version 2022/2/23
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {
        char [] chars = s.toCharArray();
        for(int i = 0,j = chars.length - 1;i < j;){
            if(!isLetter(chars[i])){
                i++;
                continue;
            }
            if(!isLetter(chars[j])){
                j--;
                continue;
            }
            char c = chars[j];
            chars[j] = chars[i];
            chars[i] = c;
            i++;
            j--;
        }
        return new String(chars);
    }
    private boolean isLetter(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}