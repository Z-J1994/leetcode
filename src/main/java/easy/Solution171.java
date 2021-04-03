package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  19:08
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = s.length() - 1,j = 1;i >= 0;i--,j *= 26){
            char c = s.charAt(i);
            sum += (c - 64) * j;
        }
        return sum;
    }
}
