package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  19:08
 */
public class Solution171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int factor = 1;
        for(int i = columnTitle.length() - 1;i >= 0;i--){
            int t = columnTitle.charAt(i) - 64;
            sum += t * factor;
            factor *= 26;
        }
        return sum;
    }
}
