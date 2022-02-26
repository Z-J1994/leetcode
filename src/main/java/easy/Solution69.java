package easy;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution69 {
    public int mySqrt(int x) {
        long k = 1;
        while(!(k * k <= x && (k + 1) * (k + 1) > x)){
            k = (x / k + k) / 2;
        }
        return (int)k;
    }
}
