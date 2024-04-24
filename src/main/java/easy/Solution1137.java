package easy;

/**
 * @author zhangjun
 * @since 2024/4/24 12:34
 */
public class Solution1137 {
    public int tribonacci(int n) {
        if(n < 2){
            return n;
        }
        int a = 0,b = 1,c = 1,d = 1;
        for(int i = 3;i <= n;i++){
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
