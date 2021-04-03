package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  20:00
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
        int count = 0;
        for(int i = 0;i < t.length();i++){
            count += t.charAt(i);
        }
        for(int i = 0;i < s.length();i++){
            count -= s.charAt(i);
        }

        return (char)count;
    }

}
