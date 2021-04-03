package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  14:31
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 0x1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
