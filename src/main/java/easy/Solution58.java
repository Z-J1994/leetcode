package easy;

/**
 * @author zhangjun
 * @version 2021/9/21
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        //There must be at least one word in s.
        while(s.charAt(--l) == ' ');
        int length = 0;
        while(l >= 0 && s.charAt(l) != ' '){
            ++length;
            --l;
        }
        return length;
    }
}
