package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 13:08
 */
public class Offer10_II {
    public int numWays(int n) {
        int a = 1,b = 1,c = 1;
        for(int i = 2;i <= n;i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
