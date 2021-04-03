package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  21:41
 */
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        if(num <= 0){
            return false;
        }
        if(bitCount(num) != 1){
            return false;
        }
        num &= 0x55555555;

        return bitCount(num) == 1;
    }
    private int bitCount(int n){
        n -= (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0F0F0F0F;
        n += n >>> 8;
        n += n >>> 16;
        return n & 0x3F;
    }

//    public boolean isPowerOfFour(int num) {
//        return num > 0 && (num & (num - 1))== 0 && (num & 0xAAAAAAAA) == 0;
//    }
}
