package easy;

/**
 * @author zhangjun
 * @version 2020/09/25  0:52
 */
public class Solution557 {
    public String reverseWords(String s) {
        char [] chars = s.toCharArray();
        int mark = 0;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                for(int j = mark,k = i - 1;j < k;j++,k--){
                    char t = chars[j];
                    chars[j] = chars[k];
                    chars[k] = t;
                }
                mark = i + 1;
            }
        }
        for(int j = mark,k = chars.length - 1;j < k;j++,k--){
            char t = chars[j];
            chars[j] = chars[k];
            chars[k] = t;
        }
        return new String(chars);
    }
}
