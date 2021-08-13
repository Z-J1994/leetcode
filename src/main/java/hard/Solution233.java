package hard;

/**
 * @author zhangjun
 * @version 2021/8/13
 */
public class Solution233 {
    public int countDigitOne(int n) {
        int count = 0;
        while(n > 0){
            int t = get(n);
            int x = n / t;
            if(x == 1){
                int k = n % t + 1;
                count += k;
                count += compute(t);
                n -= t;
            }else{
                count += t;
                count += compute(t) * x;
                n %= t;
            }
        }
        return count;
    }

    private int get(int x){
        int t = 1;
        while(x >= 10){
            t *= 10;
            x /= 10;
        }
        return t;
    }

    private int compute(int x){
        int count = 0;
        while(x > 0){
            count++;
            x /= 10;
        }
        return fastPow(count - 1) / 10 * (count - 1);
    }

    private int fastPow(int x){
        int result = 1;
        for(int i = 10;x > 0;x >>>= 1,i *= i){
            if((x & 0x1) == 1){
                result *= i;
            }
        }
        return result;
    }
}
