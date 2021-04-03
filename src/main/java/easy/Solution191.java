package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  19:13
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count += n & 0x1;
            n >>>= 1;
        }
        return count;
    }
}
