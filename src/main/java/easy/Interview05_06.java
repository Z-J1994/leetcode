package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  20:36
 */
public class Interview05_06 {
    public int convertInteger(int A, int B) {
        A ^= B;
        return bitCount(A);
    }

    private int bitCount(int n){
        n -= (n >>> 1) & 0x55555555;
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = (n + (n >>> 4)) & 0x0F0F0F0F;
        n += n >>> 8;
        n += n >>> 16;
        return n & 0x3F;
    }
}
