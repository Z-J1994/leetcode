package easy;

/**
 * @author zhangjun
 * @since 2022/6/30 12:41
 */
public class Solution1317 {
    public int[] getNoZeroIntegers(int n) {
        int subtrahend = 0;
        int m = n;
        int factory = 1;
        int carry = 0;
        while(m > 10){
            m += carry;
            int t = m % 10;
            carry = 0;
            if(t == 1){
                t -= 2;
            }else{
                t -= 1;
            }
            if(t < 0){
                t += 10;
                carry = -1;
            }
            subtrahend = subtrahend + factory * t;
            factory *= 10;
            m /= 10;
        }
        m += carry;
        if(m > 1){
            subtrahend = subtrahend + factory * (m - 1);
        }
        return new int[]{subtrahend,n - subtrahend};
    }
}
