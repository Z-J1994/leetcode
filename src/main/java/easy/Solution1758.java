package easy;

/**
 * @author zhangjun
 * @version 2022/11/29
 */
public class Solution1758 {
    public int minOperations(String s) {
        int a = 0;
        int b = 0;
        for(int i = 0,l = s.length(),c;i < l;i++){
            c = (s.charAt(i) - '0') ^ (i & 1);
            a += c;
            b += 1 - c;
        }
        return Math.min(a,b);
    }
}
