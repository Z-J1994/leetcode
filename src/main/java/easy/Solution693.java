package easy;

/**
 *
 * @author zhangjun
 * @version 2020/10/07  21:49
 */
public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        n = (n ^ (n >> 1));

        return (n & (n + 1)) == 0;
    }
}
