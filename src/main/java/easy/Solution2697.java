package easy;

/**
 * @author zhangjun
 * @since 2023/12/13 12:36
 */
public class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        char [] result = new char[s.length()];
        for(int i = 0,j = s.length() - 1;i <= j;i++,j--){
            char a = s.charAt(i);
            char b = s.charAt(j);
            char c = (a <= b) ? a : b;

            result[i] = c;
            result[j] = c;
        }
        return new String(result);
    }
}
