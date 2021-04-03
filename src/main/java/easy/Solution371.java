package easy;

/**
 *
 * @author zhangjun
 * @version 2020/10/07  22:35
 */
public class Solution371 {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
