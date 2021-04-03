package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  21:58
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        return bitCount(n) == 1;
    }

    private int bitCount(int n){
        n -= (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0F0F0F0F;
        n += n >>> 8;
        n += n >>> 16;
        return n & 0x3F;
    }

//    public boolean isPowerOfTwo(int n) {
//        if(n <= 0){
//            return false;
//        }
//        return (n & (n - 1)) == 0;
//    }
}
