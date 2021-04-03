package easy;

/**
 *
 * @author zhangjun
 * @version 2020/09/26  14:29
 */
public class Interview16_07 {
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((Math.abs(a-b) + a + b)/2);
        return res;
    }
}
