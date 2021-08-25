package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 13:22
 */
public class Offer_II_003 {
    public int[] countBits(int n) {
        int [] result = new int[n + 1];
        for(int i = 0;i <= n;i++){
            result[i] = result[i >>> 1] + (i & 1);
        }
        return result;
    }
}
