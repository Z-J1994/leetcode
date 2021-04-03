package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  19:10
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int limit = (int)Math.pow(10,n);
        int [] result = new int[--limit];
        for(int i = 0;i < limit;i++){
            result[i] = i + 1;
        }
        return result;
    }
}
