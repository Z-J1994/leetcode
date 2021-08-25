package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/25 13:05
 */
public class Offer10_I {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        int a = 0,b = 1,c = 0;
        for(int i = 2;i <= n;i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
