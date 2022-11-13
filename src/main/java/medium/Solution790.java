package medium;

/**
 * @author zhangjun
 * @version 2022/11/13
 */
public class Solution790 {
    public int numTilings(int n) {
        long a = 0,b = 1,c = 1,d = 1;
        for(int i = 2;i <= n;i++){
            d = (c * 2 + a) % 1000000007;
            a = b;
            b = c;
            c = d;
        }
        return (int)d;
    }
}
