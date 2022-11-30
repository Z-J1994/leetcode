package easy;

/**
 * @author zhangjun
 * @version 2022/11/29
 */
public class Solution1758 {
    public int minOperations(String s) {
        int a = 0;
        for(int i = 0,l = s.length();i < l;i++){
            a += (s.charAt(i) - '0') ^ (i & 1);
        }
        return Math.min(a,s.length() - a);
    }
}
