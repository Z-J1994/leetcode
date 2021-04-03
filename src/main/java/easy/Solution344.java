package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  20:00
 */
public class Solution344 {
    public void reverseString(char[] s) {
        for(int i = 0,j = s.length - 1;i < j;i++,j--){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
